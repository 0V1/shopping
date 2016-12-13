package com.qinf.shopping.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinf.shopping.pojo.User;
import com.qinf.shopping.sso.service.UserService;

import result.TaotaoResult;

/**
 * @ClassName: CreateUserController
 * @Description: 用户注册控制器
 * @author qinf QQ:908247035
 * @date 2016年12月12日
 * @version V1.0
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录页面
	 * @return
	 */
	@RequestMapping("/index")
	public String ShowIndex(){
		return "login";
	}
	
	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping("/user/showRegister")
	public String ShowRegister(){
		return "register";
	}
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/register")
	@ResponseBody
	public TaotaoResult CreateUser(User user){
		try {
			return userService.insertUser(user);
		} catch (Exception e) {
			return TaotaoResult.build(500, e.getMessage());
		}
	}
	
	/**
	 * 登录用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public TaotaoResult LoginUser(User user){
		try {
			return userService.LoginUser(user);
		} catch (Exception e) {
			return TaotaoResult.build(500, e.getMessage());
		}
	}
	
	/**
	 * 注销用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/loginOut/{token}")
	@ResponseBody
	public TaotaoResult LoginOutUser(@PathVariable String token){
		try {
			return userService.LoginOutUser(token);
		} catch (Exception e) {
			return TaotaoResult.build(500, e.getMessage());
		}
	}
	
	/**
	 * 验证令牌
	 * @param user
	 * @param callback
	 * @return
	 */
	@RequestMapping("/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token,String callback){
		TaotaoResult result = null;
		try {
			result = userService.getUserByToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			result = TaotaoResult.build(500, e.getMessage());
		}
		//判断是否为jsonp调用
		if (StringUtils.isBlank(callback)) {
			return result;
		} else {
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}
	}
	
}
