package com.qinf.shopping.service;

import com.qinf.shopping.pojo.Item;

/**
 * @ClassName: ItemService 
 * @Description: 商品接口
 * @author qinf QQ 908247035
 * @date 2016年11月29日
 */
public interface ItemService {

	/**
	 * @Description: 根据id查询商品
	 * @param: itemId
	 * @return Item 
	 */
	public Item getItemById(long itemId);
}
