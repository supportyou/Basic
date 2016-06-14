package com.basic.action;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.basic.service.impl.CheckCodeService;

public class CheckCodeAction {
	private CheckCodeService checkCodeService;

	public void execute() throws Exception {
		String real_cc = checkCodeService.randomString(4);
		//保存在session中
		ServletActionContext.getRequest()
			.getSession().setAttribute("real", real_cc);
		
		//获取向客户端响应数据的输入流
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("img/png");
		
		//为了防止客户端缓存图片，禁用客户端缓存
		response.addHeader("pragma", "no-cache");
		response.addHeader("cache-control", "no-cache");
		response.addHeader("expires", "0");
		
		ServletOutputStream out = response.getOutputStream();
		checkCodeService.renderImage(real_cc, out, 85, 34);
	}
	
	//////////////////////////////////////////////////
	public CheckCodeService getCheckCodeService() {
		return checkCodeService;
	}

	public void setCheckCodeService(CheckCodeService checkCodeService) {
		this.checkCodeService = checkCodeService;
	}
	
}


