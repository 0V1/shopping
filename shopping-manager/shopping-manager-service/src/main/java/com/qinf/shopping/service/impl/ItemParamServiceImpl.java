package com.qinf.shopping.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qinf.shopping.mapper.ItemParamMapper;
import com.qinf.shopping.pojo.ItemParam;
import com.qinf.shopping.service.ItemParamService;

import common_pojo.EUDataGridResult;

/**
 * @ClassName: ItemServiceImpl 
 * @Description: 规格参数的业务层
 * @author qinf QQ 908247035
 * @date 2016年11月29日
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private ItemParamMapper itemParamMapper;

	@Override
	public EUDataGridResult getItemParamList(Integer page, Integer rows) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<ItemParam> list = itemParamMapper.selectAll();
		//创建一个返回值
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//设置信息总数
		PageInfo<ItemParam> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public ItemParam selectItemParamByCId(Long cid) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cid", cid);
		return itemParamMapper.selectByPrimaryKey(map);
	}

	@Override
	public int saveItemParam(Long cid, String paramData) {
		ItemParam itemParam = new ItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		int res = itemParamMapper.insert(itemParam);
		return res;
	}

}
