package com.qinf.shopping.rest.service;

import java.util.List;

import com.qinf.shopping.pojo.Content;


/**
 * @ClassName: ContentService
 * @Description: 内容管理服务
 * @author qinf QQ:908247035
 * @date 2016年12月6日
 * @version V1.0
 */
public interface ContentService {

	/**
	 * 获取内容
	 * @return
	 */
	public List<Content> getContentList();
}