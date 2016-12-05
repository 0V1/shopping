package com.qinf.shopping.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinf.shopping.pojo.ItemCat;
import com.qinf.shopping.service.ItemCatService;

/**
 * @ClassName: ItemCatController 
 * @Description: TODO
 * @author qinf QQ:908247035
 * @date 2016年12月3日
 * @version V1.0
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
//	@RequestMapping("/{itemId}")
//	@ResponseBody
//	public Item getItemById(@PathVariable Long itemId) {
//		Item tbItem = itemCatService.getItemById(itemId);
//		return tbItem;
//	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/list")
	@ResponseBody
	public List categoryList(@RequestParam(value="id",defaultValue="0") Long parent_id ) {
		List catList = new ArrayList<>();
		List<ItemCat> result = itemCatService.getItemCatById(parent_id);
		for (ItemCat itemCat : result) {
			Map node = new HashMap<>();
			node.put("id", itemCat.getId());
			node.put("text", itemCat.getName());
			//如果是父节点的话就设置成关闭状态，如果是叶子节点就是open状态
			node.put("state", itemCat.getIsParent()?"closed":"open");
			catList.add(node);
		}
		return catList;
	}
}
