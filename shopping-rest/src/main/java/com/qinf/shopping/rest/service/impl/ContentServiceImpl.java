package com.qinf.shopping.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinf.shopping.mapper.ContentMapper;
import com.qinf.shopping.pojo.Content;
import com.qinf.shopping.rest.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentMapper contentMapper;
	
	@Override
	public List<Content> getContentList() {
		return contentMapper.selectAll();
	}

}
