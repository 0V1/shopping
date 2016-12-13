package com.qinf.shopping.sso.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.qinf.shopping.mapper.UserMapper;
import com.qinf.shopping.pojo.User;
import com.qinf.shopping.sso.service.UserService;

import redis.clients.jedis.Jedis;
import result.TaotaoResult;
import util.JsonUtils;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public TaotaoResult insertUser(User user) {
		user.setCreated(new Date());
		user.setUpdated(new Date());
		//md5加密
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userMapper.insert(user);
		return TaotaoResult.ok();		
	}

	@SuppressWarnings("resource")
	@Override
	public TaotaoResult LoginUser(User user) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userName", user.getUsername());
		List<User> users = userMapper.selectByPrimaryKey(map);
		//如果查询不到信息则判断此用户不存在
		if(users.size()==0) return TaotaoResult.build(400, "用户名不存在。");
		//如果能查询到信息，则对用户输入的密码加密后，判断是否一致
		User db_user = users.get(0);
		if(db_user.getPassword().equals(
				DigestUtils.md5DigestAsHex(user.getPassword().getBytes()))
				){
			String token = UUID.randomUUID().toString();
			//将用户信息保存到redis 中先把密码清空
			user.setPassword(null);
			//将用户保存在redis中，并返回token，将token添加到cookie中，其他项目访问查询cookie中是否有用户就好了
			Jedis jedis = new Jedis("127.0.0.1",6379);
			jedis.set(token, JsonUtils.objectToJson(user));
			//设置有效时间
			jedis.expire(token, 3000);
			return TaotaoResult.ok(token);
		}else{
			return TaotaoResult.build(400, "密码错误。");
		}
	}

	@SuppressWarnings("resource")
	@Override
	public TaotaoResult LoginOutUser(String token) {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		//根据token从redis中查询用户信息
		String json = jedis.get(token);
		//判断是否为空
		if (StringUtils.isBlank(json)) {
			return TaotaoResult.build(400, "此session已经过期，请重新登录");
		}
		//更新过期时间
		jedis.del(token);
		//返回用户信息
		return TaotaoResult.ok();
	}
	
	@SuppressWarnings("resource")
	@Override
	public TaotaoResult getUserByToken(String token) {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		//根据token从redis中查询用户信息
		String json = jedis.get(token);
		//判断是否为空
		if (StringUtils.isBlank(json)) {
			return TaotaoResult.build(400, "此session已经过期，请重新登录");
		}
		//更新过期时间
		jedis.expire(token, 3000);
		//返回用户信息
		return TaotaoResult.ok(JsonUtils.jsonToPojo(json, User.class));
	}

}
