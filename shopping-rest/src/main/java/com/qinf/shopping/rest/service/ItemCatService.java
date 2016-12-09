package com.qinf.shopping.rest.service;

import com.qinf.shopping.rest.pojo.CatResult;

/**
 * @ClassName: ItemCatService
 * @Description: 项目分类服务
 * @author qinf QQ:908247035
 * @date 2016年12月6日
 * @version V1.0
 */
public interface ItemCatService {

	/**
	 * 获取分类列表
	 * @return
	 */
	public CatResult getItemCatList();
}
