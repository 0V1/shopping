<<<<<<< HEAD
package com.qinf.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinf.shopping.service.ContentCategoryService;

import common_pojo.EUTreeNode;

/**
 * @ClassName: ContentCategoryController
 * @Description: 内容分类管理
 * @author qinf QQ:908247035
 * @date 2016年12月7日
 * @version V1.0
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService ContentCategoryController;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> categoryList(@RequestParam(value="id", defaultValue="0")Long parentId){
		return ContentCategoryController.getCategoryList(parentId);
	}
}
=======
package com.qinf.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinf.shopping.service.ContentCategoryService;

import common_pojo.EUTreeNode;

/**
 * @ClassName: ContentCategoryController
 * @Description: 内容分类管理
 * @author qinf QQ:908247035
 * @date 2016年12月7日
 * @version V1.0
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService ContentCategoryController;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> categoryList(@RequestParam(value="id", defaultValue="0")Long parentId){
		return ContentCategoryController.getCategoryList(parentId);
	}
}
>>>>>>> bf005f330c461f7684e15b86f0bb330bccc47e5f
