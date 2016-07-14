package com.basic.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;






import org.apache.struts2.ServletActionContext;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

//import com.lowagie.text.Document;
//import com.lowagie.text.Font;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.pdf.BaseFont;
//import com.lowagie.text.pdf.PdfWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.basic.base.BaseAction;
import com.basic.service.IStudentService;
import com.basic.test.Test;
import com.basic.pojo.Student;
import com.basic.util.DataFormat;
import com.basic.util.Page;
import com.basic.util.UploadFile;

public class StudentAction extends BaseAction {

	private static final long serialVersionUID = -910456589191114077L;
	
	private IStudentService studentService;
	private List<Student> studentList;
	private Student student;
	private Integer id;
	
	private InputStream pdfFile;
	private InputStream excelFile;
	private File uploadFile;
	private String uploadFileFileName;
	
	private final static String FILEDIR = "file"; 
	private InputStream downloadFile;
	
	//private static Logger logger = Logger.getLogger(StudentAction.class); 
	
	private Page<Student> page;
	
	//protected int pageNo = 1;
	//protected int pageSize = 4;

	private String forWhere;

    public String save(){
    	if(this.validateForm()) {
            studentService.save(student);
            return "success";
    	} else {
            return "add";
    	}
    }
    
    public String update(){
    	if(this.validateForm()) {
    		studentService.update(student);
            return "findallbypager";
    	} else {
            return "amend";
    	}
    }
    
    public String delete(){
    	student=(Student) studentService.findOne(id);
    	studentService.delete(student);
    	return "findallbypager";
    }
    
    public String findOne(){
    	
        // 记录debug级别的信息  
        //logger.debug("This is debug message.");
        // 记录info级别的信息  
        //logger.info("This is info message.");
        // 记录error级别的信息  
        //logger.error("This is error message.");
    	
    	student=(Student) studentService.findOne(id);
    	//put2Request("student", student);
    	if (forWhere.equals("amend")) {
    		return "amend";
    	} else if (forWhere.equals("copy")) {
    		return "copy";
    	} else if (forWhere.equals("pdf")) {
    		try {
    			pdfExportByTemplate();
    		} catch (Exception e) {
    			
    		}
    		return "pdf";
    	} else {
    		return "view";
    	}
    }
    
    public String findAll(){
    	studentList=studentService.findAll(student);
    	//put2Request("studentList", studentList);
    	return "findall";
    }
    
    public String findAllByPager(){
    	//page = studentService.findAllByPager(pageSize, pageNo);
    	page = studentService.findAllByPager(pageSize, pageNo, "id", true);
    	//put2Request("page", page);
    	return "findallbypager";
    }
    
    public void findAllForJson() throws Exception {
    	studentList=studentService.findAll(student);
    	
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(studentList);

		getResponse().setContentType("text/html;charset=UTF-8");
		getResponse().setHeader("cache-control", "no-cache");
		getResponse().setHeader("pragma", "no-cache");
		getResponse().setDateHeader("expires",0L);
		getResponse().getWriter().print(json);
		getResponse().getWriter().flush();
		getResponse().getWriter().close();
    }
    
    public void pdfExportByTemplate() throws Exception {
    	
    	String td = "\\template";	
		String tdf = getServletContext().getRealPath(FILEDIR+td);
    	String templateFileName = tdf+"\\template.pdf";
		try {
			PdfReader reader = new PdfReader(templateFileName);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);
			//使用中文字体 如果是利用 AcroFields填充值的不需要在程序中设置字体，在模板文件中设置字体为中文字体就行了
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
			Font font = new Font(bf, 12, Font.NORMAL);
			AcroFields s = ps.getAcroFields();
						
			//System.out.println("s: " + s);
			//System.out.println("AcroFields: " + s.getFields());
			//System.out.println("AcroFields.class: " + s.getFields().getClass());
			//System.out.println("getSignatureNames: " + s.getSignatureNames());
			//System.out.println("getSignatureNames: " + s.getTotalRevisions());
			//System.out.println("s: " + s.getBlankSignatureNames());
			//System.out.println("s: " + s.getFieldCache());
			//System.out.println("s: " + s.getSubstitutionFonts());

			s.setField("userName", student.getUserName());
			s.setField("sex", student.getSex());
			s.setField("birthday", String.valueOf(student.getBirthday()));
			s.setField("degree", student.getDegree());
			s.setField("interest", student.getInterest());
			s.setField("remark", student.getRemark());
			s.setField("nonActive", student.getNonActive());
			
			//s.setField("xh", "201314");
			//s.setField("xm", student.getUserName());
			//s.setField("xb", "男");

			ps.setFormFlattening(true);
			ps.close();
			
			String ed = "\\export";	
			String edf = getServletContext().getRealPath(FILEDIR+ed);
	    	String exportFileName = edf+"\\export.pdf";
			FileOutputStream fos = new FileOutputStream(exportFileName);
			fos.write(bos.toByteArray());
			fos.flush();
			fos.close();
		} catch (Exception e) {
			
		}
	}
    
	public String pdfExport() throws Exception {
		String ids = getRequest().getParameter("ids");
		String[] array = ids.split(",");
		int[] id = new int[array.length];
		Document document = new Document();// 创建一个document对象。
		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); // 中文处理
		Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, buffer); // 创建一个PdfWriter实例，将文件输出流指向一个文件。
		document.open(); // 打开文档。
		document.add(new Paragraph(
				"ID" + "   " + 
				"姓名" + "   " + 
				"性别" + "   " + 
				"生日" + "   " + 
				"学历", 
				fontChinese));// 在文档中增加一个段落。
		for (int i = 0; i < id.length; i++) {
			Student student = (Student) studentService.findOne(Integer.valueOf(array[i]));
			document.add(new Paragraph(
					student.getId() + "   " + 
					student.getUserName() + "   " + 
					student.getSex() + "   " + 
					student.getBirthday() + "   " + 
					student.getDegree(),
					fontChinese));// 在文档中增加一个段落。
		}
		document.close();// 关闭文档。
		pdfFile = new ByteArrayInputStream(buffer.toByteArray());
		buffer.close();
		return "pdf";
	}
	
	public String excelExport() throws Exception {
		String ids = getRequest().getParameter("ids");
		List<Student> list = new ArrayList<Student>();
		String[] array = ids.split(",");
		int[] id = new int[array.length];
		for (int i = 0; i < id.length; i++) {
			Student s = (Student) studentService.findOne(Integer.valueOf(array[i]));
			list.add(s);
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("学生信息");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("姓名");
		row.createCell(2).setCellValue("性别");
		row.createCell(3).setCellValue("生日");
		row.createCell(4).setCellValue("学历");
		row.createCell(5).setCellValue("爱好");
		row.createCell(6).setCellValue("失效");
		row.createCell(7).setCellValue("备注");

		HSSFCellStyle cellStyle = workbook.createCellStyle();
		HSSFDataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("yyyy-MM-dd"));
		
		for (int i = 1; i <= list.size(); i++) {
			Student student = list.get(i - 1);
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(student.getId());
			row.createCell(1).setCellValue(student.getUserName());
			row.createCell(2).setCellValue(student.getSex());
			//row.createCell(3).setCellStyle(cellStyle);
			row.createCell(3).setCellValue(String.valueOf(student.getBirthday()));
			row.createCell(4).setCellValue(student.getDegree());
			row.createCell(5).setCellValue(student.getInterest());
			row.createCell(6).setCellValue(student.getNonActive());
			row.createCell(7).setCellValue(student.getRemark());
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		excelFile = new ByteArrayInputStream(baos.toByteArray());
		baos.close();
		return "excel";
	}
	
	public String excelInto() throws Exception {
		String uploadDir = "/upload";		
		String targetDirectory = getServletContext().getRealPath(FILEDIR+uploadDir);
		File target = UploadFile.Upload(uploadFile, uploadFileFileName, targetDirectory);
		List<Student> studentList= new ArrayList<Student>();
		
		String fileName=target.getName();
	    String prefix=fileName.substring(fileName.lastIndexOf(".")+1);

	    if (prefix.equalsIgnoreCase("xls")) {
	    	this.excelXLSInto(target, studentList);
	    } else {
	    	this.excelXLSXInto(target, studentList);
	    }

		studentService.saveList(studentList);
		return "success";
	}
	
	//导入ExcelXLS
	public void excelXLSInto(File target, List<Student> sList) throws Exception {
		excelFile = new FileInputStream(target);
		HSSFWorkbook wb = new HSSFWorkbook(excelFile);
		HSSFSheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		for (int i = 1; i < rowNum; i++) {
			Student student = new Student();
			HSSFRow row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			for (int j = 0; j < cellNum; j++) {
				HSSFCell cell = row.getCell(j);
				String cellValue = null;
				
				if (cell!=null) {
				
					switch (cell.getCellType()) { // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
					case 0:
						cellValue = String.valueOf((int) cell.getNumericCellValue());
						break;
					case 1:
						cellValue = cell.getStringCellValue();
						break;
					case 2:
						cellValue = String.valueOf((int) cell.getNumericCellValue());
						break;
					case 3:
						cellValue = cell.getStringCellValue();
						break;
					case 4:
						cellValue = cell.getStringCellValue();
						break;
					}
					
				}
				
				switch (j) {// 通过列数来判断对应插如的字段
				case 1:
					student.setUserName(cellValue);
					break;
				case 2:
					student.setSex(cellValue);
					break;
				case 3:
					student.setBirthday(DataFormat.getDateFormat(cellValue));
					break;
				case 4:
					student.setDegree(cellValue);
					break;
				case 5:
					student.setInterest(cellValue);
					break;
				case 6:
					student.setNonActive(cellValue);
					break;
				case 7:
					student.setRemark(cellValue);;
					break;
				}
				
			}
			sList.add(student);
		}
	}
	
	// 导入ExcelXLSX
	public void excelXLSXInto(File target, List<Student> sList) throws Exception {
		excelFile = new FileInputStream(target);
		XSSFWorkbook wb = new XSSFWorkbook(excelFile);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		for (int i = 1; i < rowNum; i++) {
			Student student = new Student();
			XSSFRow row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			for (int j = 0; j < cellNum; j++) {
				XSSFCell cell = row.getCell(j);
				String cellValue = null;
				
				if (cell!=null) {
					
					switch (cell.getCellType()) { // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
					case 0:
						cellValue = String.valueOf((int) cell.getNumericCellValue());
						break;
					case 1:
						cellValue = cell.getStringCellValue();
						break;
					case 2:
						cellValue = String.valueOf((int) cell.getNumericCellValue());
						break;
					case 3:
						cellValue = cell.getStringCellValue();
						break;
					case 4:
						cellValue = cell.getStringCellValue();
						break;
					}
					
				}

				switch (j) {// 通过列数来判断对应插如的字段
				case 1:
					student.setUserName(cellValue);
					break;
				case 2:
					student.setSex(cellValue);
					break;
				case 3:
					student.setBirthday(DataFormat.getDateFormat(cellValue));
					break;
				case 4:
					student.setDegree(cellValue);
					break;
				case 5:
					student.setInterest(cellValue);
					break;
				case 6:
					student.setNonActive(cellValue);
					break;
				case 7:
					student.setRemark(cellValue);;
					break;
				}
				
			}
			sList.add(student);
		}
	}
	

    public String execute(){
    	return SUCCESS;
    }
    
	public boolean validateForm() {
		if(student!=null){
        	if (student.getUserName()==null || student.getUserName().equals("")) {
        		this.addFieldError("userName", "User Name can not be null!");
        		return false;
        	}
		} else {
			return false;
		}
		return true;
	}
    
	public IStudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Page<Student> getPage() {
		return page;
	}
	public void setPage(Page<Student> page) {
		this.page = page;
	}

	//public int getPageNo() {
		//return pageNo;
	//}

	//public void setPageNo(int pageNo) {
		//this.pageNo = pageNo;
	//}

	//public int getPageSize() {
		//return pageSize;
	//}

	//public void setPageSize(int pageSize) {
		//this.pageSize = pageSize;
	//}
	
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
	
	public InputStream getPdfFile() {
		return pdfFile;
	}
	public void setPdfFile(InputStream pdfFile) {
		this.pdfFile = pdfFile;
	}
	
	public InputStream getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(InputStream excelFile) {
		this.excelFile = excelFile;
	}
	
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
    
}
