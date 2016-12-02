package com.qinf.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinf.shopping.pojo.Item;
import com.qinf.shopping.service.ItemService;

import common_pojo.EUDataGridResult;

/**
 * @ClassName: ItemController 
 * @Description: TODO
 * @author qinf QQ:908247035
 * @date 2016年11月29日
 * @version V1.0
 */
@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/{itemId}")
	@ResponseBody
	public Item getItemById(@PathVariable Long itemId) {
		Item tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemById(Integer page, Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
}
