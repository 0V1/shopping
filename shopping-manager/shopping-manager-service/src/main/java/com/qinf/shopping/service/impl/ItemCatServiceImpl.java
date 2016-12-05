package com.qinf.shopping.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinf.shopping.mapper.ItemCatMapper;
import com.qinf.shopping.pojo.ItemCat;
import com.qinf.shopping.service.ItemCatService;

/**
 * @ClassName: ItemServiceImpl 
 * @Description: 商品列表的业务层
 * @author qinf QQ 908247035
 * @date 2016年11月29日
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatMapper itemCatMapper;

	@Override
	public List<ItemCat> getItemCatById(long parent_id) {
		
		return itemCatMapper.selectByExample(parent_id);
	}
	
}
