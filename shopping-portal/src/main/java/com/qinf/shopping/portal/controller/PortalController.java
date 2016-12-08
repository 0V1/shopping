package com.qinf.shopping.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qinf.shopping.portal.service.ContentService;

/**
 * @ClassName: PortalController
 * @Description: 页面分发控制器
 * @author qinf QQ:908247035
 * @date 2016年12月6日
 * @version V1.0
 */
@Controller
public class PortalController {
	
	@Autowired
	private ContentService contentService;

	@RequestMapping("/index")
	public String ShowIndex(Model model){
		
		String adJson = contentService.getContentList();
		model.addAttribute("ad1", adJson);
		
		return "index";
	}
	
}
