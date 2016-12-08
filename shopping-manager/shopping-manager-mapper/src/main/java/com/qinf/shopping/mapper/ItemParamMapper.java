package com.qinf.shopping.mapper;

import java.util.List;
import java.util.Map;

import com.qinf.shopping.pojo.ItemParam;

public interface ItemParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemParam record);

    int insertSelective(ItemParam record);

    ItemParam selectByPrimaryKey(Map<String,Object> map);

    int updateByPrimaryKeySelective(ItemParam record);

    int updateByPrimaryKeyWithBLOBs(ItemParam record);

    int updateByPrimaryKey(ItemParam record);

	List<ItemParam> selectAll();

}