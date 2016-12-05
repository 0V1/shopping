package com.qinf.shopping.service;

import org.springframework.web.multipart.MultipartFile;

import result.PictureResult;

/**
 * @ClassName: PicUploadService
 * @Description: 图片上传服务
 * @author qinf QQ:908247035
 * @date 2016年12月5日
 * @version V1.0
 */
public interface PicUploadService {

	/**
	 * 上传文件并回显
	 * @param uploadFile
	 * @return
	 * @throws Exception
	 */
	public PictureResult uploadFile(MultipartFile uploadFile) throws Exception;
}
