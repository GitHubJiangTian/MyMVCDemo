package com.company.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author wpjt1
 * 上传文件模块
 * file 临时文件的存储绝对路径 例如："D:\apache-tomcat-8.5.16\work\Catalina\localhost\MyMCVDemo\ upload_97530093_b818_47ba_82d5_714e6e29ef82_00000000.tmp"
 * contentType 上传文件的类型 例如："image/jpeg"
 * filename 文件名，加后缀 例如："1.jpg"
 * result 返回值，根据返回值进行判断跳转（xml配置文件中）
 */
public class UploadAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private File file;
	private String contentType;
	private String filename;
	private String result;

	public void setUpload_test(File file) {
		this.file = file;
	}

	public void setUpload_testContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setUpload_testFileName(String filename) {
		this.filename = filename;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String execute() {
		String path = "d:/upload";
		//String path1 = ServletActionContext.getServletContext().getRealPath("/image");
		//output:D:\apache-tomcat-8.5.16\webapps\MyMCVDemo\image
		File filePath = new File(path);
		if(!filePath.exists()) {
			filePath.mkdir();//此目录不存在，创建新的目录文件夹。
		}
		System.out.println("f:"+file);
		System.out.println("f:"+contentType);
		System.out.println("f:"+filename);
		try {
			FileUtils.copyFile(file, new File(filePath,filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		result = "上传成功";
		return SUCCESS;
	}

}

