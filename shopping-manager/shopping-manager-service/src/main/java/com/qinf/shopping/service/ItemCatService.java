package com.qinf.shopping.service;

import java.util.List;

import com.qinf.shopping.pojo.ItemCat;

/**
 * @ClassName: ItemService 
 * @Description: 商品接口
 * @author qinf QQ 908247035
 * @date 2016年11月29日
 */
public interface ItemCatService {

	/**
	 * @Description: 根据parent_id查询树形结构
	 * @param: itemId
	 * @return Item 
	 */
	public List<ItemCat> getItemCatById(long parent_id);
	
	
}

