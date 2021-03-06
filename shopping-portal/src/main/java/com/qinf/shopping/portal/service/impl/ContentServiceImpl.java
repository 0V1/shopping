package com.qinf.shopping.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qinf.shopping.pojo.Content;
import com.qinf.shopping.portal.service.ContentService;

import result.TaotaoResult;
import util.HttpClientUtil;
import util.JsonUtils;

@Service
public class ContentServiceImpl implements ContentService{

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_INDEX_AD_URL}")
	private String REST_INDEX_AD_URL;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String getContentList() {
		//调用服务层服务
		String result = HttpClientUtil.doGet(REST_BASE_URL+REST_INDEX_AD_URL);
		//把字符串转换成TaotaoResult
		try {
			TaotaoResult taotaoResult = TaotaoResult.formatToList(result, Content.class);
			//取内容列表
			List<Content> list = (List<Content>) taotaoResult.getData();
			List<Map> resultList = new ArrayList<>();
 			//创建一个jsp页码要求的pojo列表
			for (Content Content : list) {
				Map map = new HashMap<>();
				map.put("src", Content.getPic());
				map.put("height", 240);
				map.put("width", 670);
				map.put("srcB", Content.getPic2());
				map.put("widthB", 550);
				map.put("heightB", 240);
				map.put("href", Content.getUrl());
				map.put("alt", Content.getSubTitle());
				resultList.add(map);
			}
			return JsonUtils.objectToJson(resultList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
