package com.qinf.shopping.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinf.shopping.mapper.ItemCatMapper;
import com.qinf.shopping.pojo.ItemCat;
import com.qinf.shopping.rest.pojo.CatNode;
import com.qinf.shopping.rest.pojo.CatResult;
import com.qinf.shopping.rest.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatMapper itemCatMapper;
	
	@Override
	public CatResult getItemCatList() {
		
		CatResult catResult = new CatResult();
		//查询分类列表
		catResult.setData(getCatList(0));
		return catResult;
	}
	
	/**
	 * 查询分类列表
	 * @param parentId
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<?> getCatList(long parentId) {
		//执行查询
		List<ItemCat> list = itemCatMapper.selectByExample(parentId);
		//返回值list
		List resultList = new ArrayList<>();
		//计数器
		int i = 0;
		//向list中添加节点
		for (ItemCat tbItemCat : list) {
			//判断是否为父节点
			if (tbItemCat.getIsParent()) {
				CatNode catNode = new CatNode();
				if (parentId == 0) {
					catNode.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
				} else {
					catNode.setName(tbItemCat.getName());
				}
				catNode.setUrl("/products/"+tbItemCat.getId()+".html");
				//递归查询子节点
				catNode.setItem(getCatList(tbItemCat.getId()));
				
				resultList.add(catNode);
			//如果是叶子节点
			} else {
				resultList.add("/products/"+tbItemCat.getId()+".html|" + tbItemCat.getName());
			}
			//页面布局显示14个类目 多余的不显示
			i++;
			if(i==14) break;
		}
		return resultList;
	}

}
