<<<<<<< HEAD
package com.qinf.shopping.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinf.shopping.mapper.ContentCategoryMapper;
import com.qinf.shopping.pojo.ContentCategory;
import com.qinf.shopping.service.ContentCategoryService;

import common_pojo.EUTreeNode;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private ContentCategoryMapper categoryMapper; 
	
	@Override
	public List<EUTreeNode> getCategoryList(long parentId) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<EUTreeNode> nodes = new ArrayList<>();
		map.put("parent_id", parentId);
		//执行查询
		List<ContentCategory> list = categoryMapper.selectByPrimaryKey(map); 
		//递归构建树 
		for (ContentCategory contentCategory : list) {
			//创建一个节点
			EUTreeNode node = new EUTreeNode();
			node.setId(contentCategory.getId());
			node.setText(contentCategory.getName());
			node.setState(contentCategory.getIsParent()?"closed":"open");
			nodes.add(node);
		}
		return nodes;
	}

}

=======
package com.qinf.shopping.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinf.shopping.mapper.ContentCategoryMapper;
import com.qinf.shopping.pojo.ContentCategory;
import com.qinf.shopping.service.ContentCategoryService;

import common_pojo.EUTreeNode;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private ContentCategoryMapper categoryMapper; 
	
	@Override
	public List<EUTreeNode> getCategoryList(long parentId) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<EUTreeNode> nodes = new ArrayList<>();
		map.put("parent_id", parentId);
		//执行查询
		List<ContentCategory> list = categoryMapper.selectByPrimaryKey(map); 
		//递归构建树 
		for (ContentCategory contentCategory : list) {
			//创建一个节点
			EUTreeNode node = new EUTreeNode();
			node.setId(contentCategory.getId());
			node.setText(contentCategory.getName());
			node.setState(contentCategory.getIsParent()?"closed":"open");
			nodes.add(node);
		}
		return nodes;
	}

}

>>>>>>> bf005f330c461f7684e15b86f0bb330bccc47e5f
