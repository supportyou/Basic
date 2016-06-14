package com.basic.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.basic.base.BaseAction;
import com.basic.service.IDocumentService;
import com.basic.pojo.Document;
import com.basic.util.Page;
import com.basic.util.dataFormat;

public class DocumentAction extends BaseAction {

	private static final long serialVersionUID = -910456589191114077L;
	
	private IDocumentService documentService;
	private List<Document> documentList;
	private Document document;
	private Integer id;
	
	private Page<Document> page;

	private String forWhere;
	
	//---------------------------------------------
	private final static String UPLOADDIR = "/upload";   
	private List<File> file;
	private List<String> fileFileName;
	private List<String> fileContentType;
	
	private List<String> fileTopic = new ArrayList<String>();
	private List<String> fileName = new ArrayList<String>();
	private List<Integer> fileSize = new ArrayList<Integer>();
	private List<String> newFileName = new ArrayList<String>();
	private List<String> uploadTime = new ArrayList<String>();
	//---------------------------------------------
	

    public String save() throws Exception {
    	//if(this.validateForm()) {
            //documentService.save(document);
            //return "success";
    	//} else {
            //return "add";
    	//}
    	if(file!=null&&file.size()>0) {
	    	for (int i = 0; i < file.size(); i++) {  
				this.uploadFile(i); 
				
				document = new Document();
				
				document.setFileTopic(fileTopic.get(i));
				document.setFileName(fileName.get(i));
				document.setFileContentType(fileContentType.get(i));
				document.setFileSize(fileSize.get(i));
				document.setNewFileName(newFileName.get(i));
				document.setUploadTime(uploadTime.get(i));
				
				documentService.save(document);
			}
    	}
    	return "success";
    }
    
    public String update() throws Exception {
    	//Because no get/set method, just has get/set list method
    	//if(this.validateForm()) {
    		//---------
    		Document dd=(Document) documentService.findOne(document.getId());
    		document.setFileTopic(document.getFileTopic());
    		
    		document.setFileName(dd.getFileName());
			document.setFileContentType(dd.getFileContentType());
			document.setFileSize(dd.getFileSize());
			document.setNewFileName(dd.getNewFileName());
			document.setUploadTime(dd.getUploadTime());	

    		if(file!=null&&file.size()>0) {
				for (int i = 0; i < file.size(); i++) {
	        		if(this.deleteFile(dd.getNewFileName())) {}
	        		this.uploadFile(i);
	        		
	        		System.out.println("4:"+fileName.get(i));
	
	        		document.setFileName(fileName.get(i));
	    			document.setFileContentType(fileContentType.get(i));
	    			document.setFileSize(fileSize.get(i));
	    			document.setNewFileName(newFileName.get(i));
	    			document.setUploadTime(uploadTime.get(i));	
	    		}
    		}

    		documentService.update(document);
    		
            return "findallbypager";
    	//} else {
            //return "amend";
    	//}
    }
    
    public String delete(){
    	document=(Document) documentService.findOne(id);
    	if(this.deleteFile(document.getNewFileName())) {}
    	documentService.delete(document);
    	return "findallbypager";
    }
    
    public String findOne(){
    	document=(Document) documentService.findOne(id);
    	//put2Request("document", document);
    	if (forWhere.equals("amend")) {
    		return "amend";
    	} else if (forWhere.equals("copy")) {
    		return "copy";
    	} else {
    		return "view";
    	}
    }
    
    public String findAll(){
    	documentList=documentService.findAll(document);
    	//put2Request("documentList", documentList);
    	return "findall";
    }
    
    public String findAllByPager(){
    	//page = documentService.findAllByPager(pageSize, pageNo);
    	page = documentService.findAllByPager(pageSize, pageNo, "id", true);
    	//put2Request("page", page);
    	return "findallbypager";
    }
    
    public void findAllForJson() throws Exception {
    	documentList=documentService.findAll(document);
    	
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(documentList);

		getResponse().setContentType("text/html;charset=UTF-8");
		getResponse().setHeader("cache-control", "no-cache");
		getResponse().setHeader("pragma", "no-cache");
		getResponse().setDateHeader("expires",0L);
		getResponse().getWriter().print(json);
		getResponse().getWriter().flush();
		getResponse().getWriter().close();
    }

    public String execute(){
    	return SUCCESS;
    }
    
	public boolean validateForm() {
		if(document!=null){
        	if (document.getFileTopic()==null || document.getFileTopic().equals("")) {
        		this.addFieldError("fileTopic", "File Topic can not be null!");
        		return false;
        	}
		} else {
			return false;
		}
		return true;
	}
	
	//---------------------------------------------
	private void uploadFile(int i) throws FileNotFoundException, IOException {   
		try {   
			InputStream in = new FileInputStream(file.get(i));   
			String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);  
			File fileLocation = new File(dir);  
			if(!fileLocation.exists()){  
				boolean isCreated  = fileLocation.mkdir();  
				if(!isCreated) {
					return;  
				}  
			}  
	
			//String myFileName=this.getFileFileName().get(i);
			String myFileName=this.createNewFileName()+"_"+i+"_"+this.getFileFileName().get(i);

			//fileTopic.set(i, this.getFileTopic().get(i));
			//fileName.set(i, this.getFileFileName().get(i));
			//fileContentType.set(i, this.getFileContentType().get(i));
			//fileSize.set(i, in.available());
			//newFileName.set(i, this.createNewFileName()+"_"+i+"_"+this.getFileFileName().get(i));
			//uploadTime.set(i, dataFormat.getDate());
			
			//fileTopic.add(this.getFileTopic().get(i));
			fileName.add(this.getFileFileName().get(i));
			fileContentType.add(this.getFileContentType().get(i));
			fileSize.add(in.available());
			newFileName.add(this.createNewFileName()+"_"+i+"_"+this.getFileFileName().get(i));
			uploadTime.add(dataFormat.getDateTime());
			
			File uploadFile = new File(dir, myFileName);   
			OutputStream out = new FileOutputStream(uploadFile);   
			byte[] buffer = new byte[1024 * 1024];   
			int length;   
			while ((length = in.read(buffer)) > 0) {   
				out.write(buffer, 0, length);   
			}   
			in.close();   
			out.close();   
		} catch (FileNotFoundException ex) {   
			System.out.println("上传失败!");  
			ex.printStackTrace();   
		} catch (IOException ex) {   
			System.out.println("上传失败!");  
			ex.printStackTrace();   
		}   
	}
	
	public boolean deleteFile(String fileName) {
		String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);
		File file=new File(dir, fileName);
		if(file.exists()) {
			file.delete();
			return true;
		}
		return false;
	}
			
	public String createNewFileName() {
		Date dt = new Date();  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSSS"); 
		return sdf.format(dt);
	}
	//---------------------------------------------
    
	public IDocumentService getDocumentService() {
		return documentService;
	}
	public void setDocumentService(IDocumentService documentService) {
		this.documentService = documentService;
	}

	public List<Document> getDocumentList() {
		return documentList;
	}
	public void setDocumentList(List<Document> documentList) {
		this.documentList = documentList;
	}
	
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	
	public Page<Document> getPage() {
		return page;
	}
	public void setPage(Page<Document> page) {
		this.page = page;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getForWhere() {
		return forWhere;
	}
	public void setForWhere(String forWhere) {
		this.forWhere = forWhere;
	}
	
	//---------------------------------------------
	public List<File> getFile() {   
		return file;   
	}
	public void setFile(List<File> file) {   
		this.file = file;   
	}   
	
	public List<String> getFileFileName() {   
		return fileFileName;   
	}   
	public void setFileFileName(List<String> fileFileName) {   
		this.fileFileName = fileFileName;   
	}   
	
	public List<String> getFileContentType() {   
		return fileContentType;   
	}   
	public void setFileContentType(List<String> fileContentType) {   
		this.fileContentType = fileContentType;   
	}
	
	public List<String> getFileTopic() {   
		return fileTopic;   
	}   
	public void setFileTopic(List<String> fileTopic) {   
		this.fileTopic = fileTopic;   
	}
	
	public List<String> getFileName() {   
		return fileName;   
	}   
	public void setFileName(List<String> fileName) {   
		this.fileName = fileName;   
	}
	
	public List<Integer> getFileSize() {   
		return fileSize;   
	}   
	public void setFileSize(List<Integer> fileSize) {   
		this.fileSize = fileSize;   
	}
	
	public List<String> getNewFileName() {   
		return newFileName;   
	}   
	public void setNewFileName(List<String> newFileName) {   
		this.newFileName = newFileName;   
	}
	
	public List<String> getUploadTime() {   
		return uploadTime;   
	}   
	public void setUploadTime(List<String> uploadTime) {   
		this.uploadTime = uploadTime;   
	}
	//---------------------------------------------
    
}
