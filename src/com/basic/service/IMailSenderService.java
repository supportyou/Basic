package com.basic.service;

import java.util.Map;

public interface IMailSenderService {
	public void sendWithTemplate(Map model);
    public void sendText();   
    public void sendHtml();
    public void sendHtmlWithImage(String imagePath); 
    public void sendHtmlWithAttachment(String filePath);
    public void myTest();
}
