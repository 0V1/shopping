package com.qinf.shopping.service;

import java.util.List;

import common_pojo.EUTreeNode;

/**
 * @ClassName: ContentCategoryService
 * @Description: 内容分类管理
 * @author qinf QQ:908247035
 * @date 2016年12月7日
 * @version V1.0
 */
public interface ContentCategoryService {

	public List<EUTreeNode> getCategoryList(long parentId);
}
