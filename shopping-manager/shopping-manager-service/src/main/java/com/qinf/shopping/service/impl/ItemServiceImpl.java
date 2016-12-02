package com.qinf.shopping.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qinf.shopping.mapper.ItemMapper;
import com.qinf.shopping.pojo.Item;
import com.qinf.shopping.service.ItemService;

import common_pojo.EUDataGridResult;

/**
 * @ClassName: ItemServiceImpl 
 * @Description: 商品列表的业务层
 * @author qinf QQ 908247035
 * @date 2016年11月29日
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	public Item getItemById(long itemId) {
		
		return itemMapper.selectByPrimaryKey(itemId);
	}

	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Item> list = itemMapper.selectAll();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Item> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
