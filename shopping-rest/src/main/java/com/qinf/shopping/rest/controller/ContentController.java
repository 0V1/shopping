package com.qinf.shopping.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinf.shopping.pojo.Content;
import com.qinf.shopping.rest.service.ContentService;

import result.TaotaoResult;
import util.JsonUtils;

/**
 * @ClassName: ContentController
 * @Description: 内容管理控制器
 * @author qinf QQ:908247035
 * @date 2016年12月6日
 * @version V1.0
 */
@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/index_ad_url")
	@ResponseBody
	public String ShowIndex(){
		List<Content> list = contentService.getContentList();
		TaotaoResult res = new TaotaoResult();
		res.setData(list);
		//把pojo转换成字符串
		String json = JsonUtils.objectToJson(res);
		System.out.println("httpclient 访问成功");
		return json;
	}
	
}
