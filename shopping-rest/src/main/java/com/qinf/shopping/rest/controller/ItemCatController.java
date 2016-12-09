<<<<<<< HEAD
package com.qinf.shopping.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinf.shopping.rest.pojo.CatResult;
import com.qinf.shopping.rest.service.ItemCatService;

import util.JsonUtils;

/**
 * @ClassName: ItemCatController
 * @Description: TODO
 * @author qinf QQ:908247035
 * @date 2016年12月6日
 * @version V1.0
 */
@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 此处路径对应portal系统中访问过来的路径
	 * 例:http://127.0.0.1:8081/rest/itemcat/list?callback=category.getDataService
	 * @param callback
	 * @return
	 */
	@RequestMapping(value="/itemcat/list", produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback){
		CatResult catResult = itemCatService.getItemCatList();
		//把pojo转换成字符串
		String json = JsonUtils.objectToJson(catResult);
		//拼装返回值
		String result = callback + "(" + json + ");";
		return result;
	}
}
=======
package com.qinf.shopping.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinf.shopping.rest.pojo.CatResult;
import com.qinf.shopping.rest.service.ItemCatService;

import util.JsonUtils;

/**
 * @ClassName: ItemCatController
 * @Description: TODO
 * @author qinf QQ:908247035
 * @date 2016年12月6日
 * @version V1.0
 */
@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 此处路径对应portal系统中访问过来的路径
	 * 例:http://127.0.0.1:8081/rest/itemcat/list?callback=category.getDataService
	 * @param callback
	 * @return
	 */
	@RequestMapping(value="/itemcat/list", produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback){
		CatResult catResult = itemCatService.getItemCatList();
		//把pojo转换成字符串
		String json = JsonUtils.objectToJson(catResult);
		//拼装返回值
		String result = callback + "(" + json + ");";
		return result;
	}
}
>>>>>>> bf005f330c461f7684e15b86f0bb330bccc47e5f
