package com.qinf.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinf.shopping.pojo.Item;
import com.qinf.shopping.service.ItemService;

/**
 * @ClassName: ItemController 
 * @Description: TODO
 * @author qinf QQ:908247035
 * @date 2016年11月29日
 * @version V1.0
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public Item getItemById(@PathVariable Long itemId) {
		Item tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
}
