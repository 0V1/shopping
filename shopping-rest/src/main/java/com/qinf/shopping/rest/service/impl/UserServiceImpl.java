package com.qinf.shopping.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.qinf.shopping.pojo.User;
import com.qinf.shopping.rest.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
    public User insertUser() {
        System.out.println("@Cacheable注解方法被调用啦。。。。。");
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setId((long) 123);
        user.setEmail("192554785@163.com");
        return user;
    }
    
    @CacheEvict(value = "user", key = "'id_'+#id")
    public User deleteUserByID(Integer id) {
        System.out.println("@CacheEvict注解方法被调用啦。。。。。");
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setId((long) 123);
        user.setEmail("192554785@163.com");
        return user;
    }
	
    @Cacheable(value = "user", key = "'id_'+#id") //,key="'user_id_'+#id"
    public User changeUserByID(Integer id) {
        System.out.println("@Cacheable注解方法被调用啦。。。。。");
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setId((long) 123);
        user.setEmail("192554785@163.com");
        return user;
    }
    
    @CachePut(value = "users", key = "'users_'+#user.getId()")
    public List<User> getUsers(User user) {
        System.out.println("@CachePut注解方法被调用啦。。。。。");
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User temp = new User();
            temp.setUsername("username" + i);
            users.add(temp);
        }
        return users;
    }
}