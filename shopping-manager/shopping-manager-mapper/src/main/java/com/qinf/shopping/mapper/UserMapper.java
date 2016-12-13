package com.qinf.shopping.mapper;

import java.util.List;
import java.util.Map;

import com.qinf.shopping.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByPrimaryKey(Map<String, Object> map);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}