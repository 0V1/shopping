package com.qinf.shopping.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qinf.shopping.service.PicUploadService;

import result.PictureResult;
import util.FtpUtil;
import util.IDUtils;
@Service
public class PicUploadServiceImpl implements PicUploadService {

	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	@Value("${FILI_UPLOAD_PATH}")
	private String FILI_UPLOAD_PATH;
	@Value("${FTP_SERVER_IP}")
	private String FTP_SERVER_IP;
	@Value("${FTP_SERVER_PORT}")
	private Integer FTP_SERVER_PORT;
	@Value("${FTP_SERVER_USERNAME}")
	private String FTP_SERVER_USERNAME;
	@Value("${FTP_SERVER_PASSWORD}")
	private String FTP_SERVER_PASSWORD;
	
	@Override
	public PictureResult uploadFile(MultipartFile uploadFile) throws Exception {

		//上传
		String path = savePicture(uploadFile);
		//回显
		PictureResult result;
		if(null != path){
			result = new PictureResult(0,IMAGE_BASE_URL+path);
		}else{
			result = new PictureResult(1,null,"文件为空。");
		}
		return result ;
	}
	
	/**
	 * 上传
	 * @param uploadFile
	 * @return
	 */
	private String savePicture(MultipartFile uploadFile) {
		String path = null;
			
		try {
			//判断文件是否为空
			if(uploadFile.isEmpty()) return null;
		
			//上传文件以日期为单位分开文件夹存放，可以提高查询效率
			String filePath = "/"+new SimpleDateFormat("yyyy").format(new Date())+"/"
					+ new SimpleDateFormat("MM").format(new Date())+"/"
					+ new SimpleDateFormat("dd").format(new Date());
			//取原始文件名
			String originalFileName = uploadFile.getOriginalFilename();
			//拼装新文件名
			String newFileName = IDUtils.genImageName()
					+originalFileName.substring(originalFileName.indexOf("."));
			//转存文件上传到ftp
			FtpUtil.uploadFile(FTP_SERVER_IP, FTP_SERVER_PORT, FTP_SERVER_USERNAME, 
					FTP_SERVER_PASSWORD, FILI_UPLOAD_PATH, filePath, newFileName, 
					uploadFile.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
