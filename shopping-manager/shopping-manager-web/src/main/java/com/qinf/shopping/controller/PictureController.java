package com.qinf.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.qinf.shopping.service.PicUploadService;

import result.PictureResult;

/**
 * @ClassName: PictureController
 * @Description: 图片上传
 * @author qinf QQ:908247035
 * @date 2016年12月5日
 * @version V1.0
 */
@Controller
@RequestMapping(value="/pic")
public class PictureController {

	@Autowired
	private PicUploadService picUploadService;
	
	@RequestMapping(value="/upload")
	public PictureResult upload(MultipartFile uploadFile) throws Exception{
		
		return picUploadService.uploadFile(uploadFile);
	}
}
