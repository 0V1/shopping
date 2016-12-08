package com.qinf.shopping.mapper;

import java.util.List;
import java.util.Map;

import com.qinf.shopping.pojo.ContentCategory;

public interface ContentCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContentCategory record);

    int insertSelective(ContentCategory record);

    List<ContentCategory> selectByPrimaryKey(Map<String, Object> map);

    int updateByPrimaryKeySelective(ContentCategory record);

    int updateByPrimaryKey(ContentCategory record);
}