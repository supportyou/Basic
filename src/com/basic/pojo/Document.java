package com.basic.pojo;

// Generated 2016-6-12 11:03:45 by Hibernate Tools 3.4.0.CR1

/**
 * Document generated by hbm2java
 */
public class Document implements java.io.Serializable {

	private Integer id;
	private String fileTopic;
	private String fileName;
	private String fileContentType;
	private Integer fileSize;
	private String newFileName;
	private String uploadTime;

	public Document() {
	}

	public Document(String fileTopic, String fileName, String fileContentType,
			Integer fileSize, String newFileName, String uploadTime) {
		this.fileTopic = fileTopic;
		this.fileName = fileName;
		this.fileContentType = fileContentType;
		this.fileSize = fileSize;
		this.newFileName = newFileName;
		this.uploadTime = uploadTime;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileTopic() {
		return this.fileTopic;
	}

	public void setFileTopic(String fileTopic) {
		this.fileTopic = fileTopic;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileContentType() {
		return this.fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public Integer getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public String getNewFileName() {
		return this.newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public String getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

}