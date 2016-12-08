package com.qinf.shopping.rest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ClassName: CatNode
 * @Description: 分类列表的节点。包含u、n、i属性
 * @author qinf QQ:908247035
 * @date 2016年12月6日
 * @version V1.0
 */
public class CatNode {

	@JsonProperty("n")
	private String name;
	
	@JsonProperty("u")
	private String url;
	
	@JsonProperty("i")
	private List<?> item;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<?> getItem() {
		return item;
	}

	public void setItem(List<?> item) {
		this.item = item;
	}
	
}
