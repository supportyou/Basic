package com.basic.action;

import java.io.InputStream;  

import org.apache.struts2.ServletActionContext;  

import com.opensymphony.xwork2.ActionSupport;  

import com.basic.util.dataFormat;;

public class DownloadAction extends ActionSupport {  

	private InputStream downloadFile;  
	private String fileName;
	private String newFileName;
	
	public String getDownloadFileName() {  
        String downFileName = fileName;  
        try {  
            downFileName = new String(downFileName.getBytes(), "ISO8859-1");  
        } catch (Exception e) {  
        }  
        return downFileName;  
    }  
	
	public InputStream getDownloadFile() {
		//Because Tomcat/conf/server.xml add URIEncoding="UTF-8"
		//return ServletActionContext.getServletContext().getResourceAsStream("/upload/"+dataFormat.getGbk(fileName)); 
		//return ServletActionContext.getServletContext().getResourceAsStream("/upload/"+fileName);
		return ServletActionContext.getServletContext().getResourceAsStream("/upload/"+newFileName);
	}  
	public void setDownloadFile(InputStream downloadFile) {  
		this.downloadFile = downloadFile;  
	}  
	
	public String execute() throws Exception{  
		//downloadFile=ServletActionContext.getServletContext().getResourceAsStream("/upload/"+dataFormat.getGbk(fileName));  
		return "success";  
	}
	
	
	public String getFileName() {  
		return fileName;  
	}  
	public void setFileName(String fileName) {  
		this.fileName = fileName;  
	}
	
	public String getNewFileName() {  
		return newFileName;  
	}  
	public void setNewFileName(String newFileName) {  
		this.newFileName = newFileName;  
	}
} 
