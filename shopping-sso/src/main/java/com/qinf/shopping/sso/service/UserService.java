package com.qinf.shopping.sso.service;

import com.qinf.shopping.pojo.User;

import result.TaotaoResult;
/**
 * @ClassName: UserService
 * @Description: 用户服务
 * @author qinf QQ:908247035
 * @date 2016年12月12日
 * @version V1.0
 */
public interface UserService {

	public TaotaoResult insertUser(User user);

	public TaotaoResult LoginUser(User user);

	TaotaoResult getUserByToken(String token);

	TaotaoResult LoginOutUser(String token);
}
