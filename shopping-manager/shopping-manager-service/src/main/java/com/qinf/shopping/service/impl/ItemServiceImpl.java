package com.qinf.shopping.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinf.shopping.mapper.ItemMapper;
import com.qinf.shopping.pojo.Item;
import com.qinf.shopping.service.ItemService;

/**
 * @ClassName: ItemServiceImpl 
 * @Description: 商品列表的业务层
 * @author qinf QQ 908247035
 * @date 2016年11月29日
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	public Item getItemById(long itemId) {
		
		return itemMapper.selectByPrimaryKey(itemId);
	}

}
