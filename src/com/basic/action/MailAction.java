package com.basic.action;

import java.util.HashMap;
import java.util.Map;

import com.basic.base.BaseAction;
import com.basic.service.impl.MailSenderService;

public class MailAction extends BaseAction{

	private static final long serialVersionUID = -910456589191114077L;
	
	private MailSenderService mailSenderService;
 
    public String execute(){
    	
    	String to="rock_shi@shenship.com";
    	String subject="来自S2SH的邮件";
    	String content="测试，Testing...!!!";
    	
    	String imagePath="D:\\test\\Simpleisbest.jpg";
    	String filePath="D:\\test\\2016 调整后的价格表.docx";
    	
    	String templateName="mail.vm";
    	String userName="Rock Shi";
    	String email="supportyou@126.com";
    	
    	mailSenderService.setTo(to);  
    	mailSenderService.setSubject(subject);
    	mailSenderService.setContent(content);
    	
    	mailSenderService.setTemplateName(templateName);
    	Map model=new HashMap();  
    	model.put("userName", userName);  
    	model.put("content", content); 
    	model.put("email", email);
    	
    	//mailSenderService.sendTextWithTemplate(model);  
    	//mailSenderService.sendHtmlWithTemplate(model);
    	//mailSenderService.sendText();
    	//mailSenderService.sendHtml();
    	//mailSenderService.sendHtmlWithImage(imagePath);
    	mailSenderService.sendHtmlWithAttachment(filePath);
    	
    	System.out.println("邮件发送成功！");  
    	
    	return SUCCESS;
    }
    
	public MailSenderService getMailSenderService() {
		return mailSenderService;
	}
	public void setMailSenderService(MailSenderService mailSenderService) {
		this.mailSenderService = mailSenderService;
	}

}
