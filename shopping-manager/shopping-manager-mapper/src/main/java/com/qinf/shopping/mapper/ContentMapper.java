package com.qinf.shopping.mapper;

import java.util.List;

import com.qinf.shopping.pojo.Content;

public interface ContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Long i);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKeyWithBLOBs(Content record);

    int updateByPrimaryKey(Content record);

	List<Content> selectAll();
}