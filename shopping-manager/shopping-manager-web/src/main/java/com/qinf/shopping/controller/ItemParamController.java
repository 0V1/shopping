package com.qinf.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinf.shopping.pojo.ItemParam;
import com.qinf.shopping.service.ItemParamService;

import common_pojo.EUDataGridResult;
import result.TaotaoResult;

/**
 * @ClassName: ItemCatController 
 * @Description: 规格参数
 * @author qinf QQ:908247035
 * @date 2016年12月3日
 * @version V1.0
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping(value="/list")
	@ResponseBody
	private EUDataGridResult getItemParamByPage(Integer page,Integer rows){
		EUDataGridResult res = itemParamService.getItemParamList(page, rows);
		return res;
	}
	
	@RequestMapping(value="/query/itemcatid/{cid}")
	@ResponseBody
	private TaotaoResult queryCatalogById(@PathVariable Long cid){
		ItemParam res = itemParamService.selectItemParamByCId(cid);
		//如果查询中有结果返回查询结果
		if (res != null) {
			return TaotaoResult.ok(res);
		}
		//查询成功但是没有查到数据
		return TaotaoResult.ok();
	}
	
	@RequestMapping(value="/save/{cid}")
	@ResponseBody
	private TaotaoResult saveItemParam(@PathVariable Long cid, String paramData){
		int res = itemParamService.saveItemParam(cid, paramData);
		System.out.println("保存成功条数:"+res);
		return TaotaoResult.ok();
//		return null;
	}
}
