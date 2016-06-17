package com.basic.service.impl;

import java.io.File;  
import java.io.UnsupportedEncodingException;
import java.util.Map;  

import javax.mail.MessagingException;  
import javax.mail.internet.MimeMessage;  

import org.apache.velocity.app.VelocityEngine;  
import org.springframework.core.io.FileSystemResource;  
import org.springframework.mail.SimpleMailMessage;  
import org.springframework.mail.javamail.JavaMailSender;  
import org.springframework.mail.javamail.MimeMessageHelper;  
import org.springframework.ui.velocity.VelocityEngineUtils; 



//因为没有实现接口, 所以也不需要在Action中以接口来声明, 可在下面加UTF-8
import com.basic.service.IMailSenderService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;
  
public class MailSenderService {  
    private JavaMailSender mailSender;//spring配置中定义  
    private VelocityEngine velocityEngine;//spring配置中定义  
    private SimpleMailMessage simpleMailMessage;//spring配置中定义  
    private String from;  
    private String to;  
    private String subject;  
    private String content;  
    private String templateName;  
    // 是否需要身份验证     
    private boolean validate = false;   

    public JavaMailSender getMailSender() {  
        return mailSender;  
    }  
    public void setMailSender(JavaMailSender mailSender) {  
        this.mailSender = mailSender;  
    }
    public VelocityEngine getVelocityEngine() {  
        return velocityEngine;  
    }  
    public void setVelocityEngine(VelocityEngine velocityEngine) {  
        this.velocityEngine = velocityEngine;  
    }  
    public SimpleMailMessage getSimpleMailMessage() {  
        return simpleMailMessage;  
    }  
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {  
        this.simpleMailMessage = simpleMailMessage;  
    } 

    
    public void sendTextWithTemplate(Map model){
        simpleMailMessage.setTo(this.getTo());
        simpleMailMessage.setFrom(simpleMailMessage.getFrom()); //发送人,从配置文件中取得  
        simpleMailMessage.setSubject(this.getSubject());  
        String result = null;
        try {  
            result = VelocityEngineUtils.mergeTemplateIntoString(this.getVelocityEngine(), this.getTemplateName(), "UTF-8",model);
            
        } catch (Exception e) {} 
        simpleMailMessage.setText(result);
        mailSender.send(simpleMailMessage);  
    }

    public void sendHtmlWithTemplate(Map model){
        MimeMessage mimeMessage = mailSender.createMimeMessage();  
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);  
        String result = null;  
        try {  
            messageHelper.setTo(this.getTo());
            messageHelper.setFrom(simpleMailMessage.getFrom());
            messageHelper.setSubject(this.getSubject());  
            result = VelocityEngineUtils.mergeTemplateIntoString(this.getVelocityEngine(), this.getTemplateName(), "UTF-8", model);
            messageHelper.setText(result,true);
        } catch (Exception e) {} 
        mailSender.send(mimeMessage);  
    }  

    public void sendText(){  
        simpleMailMessage.setTo(this.getTo());
        simpleMailMessage.setFrom(simpleMailMessage.getFrom());
        simpleMailMessage.setSubject(this.getSubject());  
        simpleMailMessage.setText(this.getContent());  
        mailSender.send(simpleMailMessage);  
    }  

    public void sendHtml(){  
        MimeMessage mimeMessage = mailSender.createMimeMessage();  
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);  
        try {  
        	
            messageHelper.setTo(this.getTo());  
            messageHelper.setFrom(simpleMailMessage.getFrom());  
            messageHelper.setSubject(this.getSubject()); 
            //String html = "<html><head></head><body><h1>Hello</h1>" +this.getContent()+ "</body></html>"; 
            messageHelper.setText(this.getContent(),true); //true表示启动HTML格式的邮件      
        } catch (MessagingException e) {  
            e.printStackTrace();  
        }  
        mailSender.send(mimeMessage);  
    }  

    public void sendHtmlWithImage(String imagePath){  
        MimeMessage mimeMessage = mailSender.createMimeMessage();  
        try {  
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");  
            messageHelper.setTo(this.getTo());  
            messageHelper.setFrom(simpleMailMessage.getFrom());  
            messageHelper.setSubject(this.getSubject());  
            String Content="<html><head></head><body>Hello,<br><img src=\"cid:image\"/></body></html>";  
            //图片必须这样子：<img src='cid:image'/>, 此处的image必须与addInline("image",img)中的image对应
            //messageHelper.setText(this.getContent(),true);
            messageHelper.setText(Content,true);
            FileSystemResource img = new FileSystemResource(new File(imagePath));  
            messageHelper.addInline("image",img);  
        } catch (MessagingException e) {  
            e.printStackTrace();  
        }  
        mailSender.send(mimeMessage);  
    }  

    public void sendHtmlWithAttachment(String filePath){  
        MimeMessage mimeMessage = mailSender.createMimeMessage();  
        try {  
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);  
            messageHelper.setTo(this.getTo());  
            messageHelper.setFrom(simpleMailMessage.getFrom());  
            messageHelper.setSubject(this.getSubject());  
            messageHelper.setText(this.getContent(),true);  
            FileSystemResource file = new FileSystemResource(new File(filePath));  
            //System.out.println("file.getFilename:"+file.getFilename());  
            
            //addAttachment addInline 两种附件添加方式
            //以附件的形式添加到邮件
            //使用MimeUtility.encodeWord 解决附件名中文乱码的问题
            
            messageHelper.addAttachment(MimeUtility.encodeWord(file.getFilename()),file);
            //messageHelper.addAttachment(file.getFilename(),file);
        } catch (MessagingException e) {  
            e.printStackTrace();  
        }  catch (UnsupportedEncodingException e) {
        	e.printStackTrace();
        }
        mailSender.send(mimeMessage);  
    } 
    
    
    public String getFrom() {  
        return from;  
    }  
    public void setFrom(String from) {  
        this.from = from;  
    }  
    public String getSubject() {  
        return subject;  
    }  
    public void setSubject(String subject) {  
        this.subject = subject;  
    }  
    public String getTo() {  
        return to;  
    }  
    public void setTo(String to) {  
        this.to = to;  
    }  
    public String getTemplateName() {  
        return templateName;  
    }  
    public void setTemplateName(String templateName) {  
        this.templateName = templateName;  
    }  
    public String getContent() {  
        return content;  
    }  
    public void setContent(String content) {  
        this.content = content;  
    }  
    public boolean isValidate() {  
        return validate;  
    }  
    public void setValidate(boolean validate) {  
        this.validate = validate;  
    }  
 
}  
