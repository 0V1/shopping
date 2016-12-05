package com.qinf.shopping.service;

import com.qinf.shopping.pojo.ItemParam;

import common_pojo.EUDataGridResult;

/**
 * @ClassName: ItemService 
 * @Description: 规格参数接口
 * @author qinf QQ 908247035
 * @date 2016年11月29日
 */
public interface ItemParamService {

	/**
	 * 查询规格参数
	 * @param page
	 * @param rows
	 * @return
	 */
	public EUDataGridResult getItemParamList(Integer page, Integer rows);
	
	/**
	 * 根据item_cat_id查找是否存在
	 * @param cid
	 * @return
	 */
	public ItemParam selectItemParamByCId(Long cid);

	/**
	 * 增加规格参数
	 * @param cid
	 * @param paramData
	 * @return
	 */
	public int saveItemParam(Long cid, String paramData);
	
}

