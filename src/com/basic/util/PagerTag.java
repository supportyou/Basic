package com.basic.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PagerTag extends TagSupport{

	private static final long serialVersionUID = 3294445566873540640L;
	private String url = "";
	private int pageSize = 3;
	private int pageNo = 1;
	private int totalElements = 0;

	public int doStartTag() throws JspException {
		StringBuilder sb = new StringBuilder();

		
		if (this.totalElements == 0) {
			sb.append("<strong>没有可显示的项目</strong>\r\n");
		} else {
			int totalPages = (totalElements + pageSize - 1) / pageSize;
			if (pageNo > totalPages) {
				pageNo = totalPages;
			}
			if (pageNo < 1) {
				pageNo = 1;
			}
			
			String id = UUID.randomUUID().toString().replaceAll("-", "");

			sb.append("<form method=\"post\" action=\"").append(this.url)
					.append("\" id=\"" + id + "\">\r\n");
			HttpServletRequest request = (HttpServletRequest) this.pageContext
					.getRequest();
			//获得所有需要传递的参数
			Enumeration<String> enumeration = request.getParameterNames();
			
			String name = null;
			String value = null;
			while (enumeration.hasMoreElements()) {
				name = (String) enumeration.nextElement();
				value = request.getParameter(name);
				if (name.equals("pageNo")) {
					if ((value != null) && (!"".equals(value)))
						pageNo = Integer.parseInt(value);
				} else {
					sb.append("<input type=\"hidden\" name=\"").append(name)
							.append("\" value=\"").append(value)
							.append("\"/>\r\n");
				}
			}

			sb.append("<input type=\"hidden\" name=\"").append("pageNo")
					.append("\" value=\"").append(pageNo)
					.append("\"/>\r\n");
			
			sb.append("<ul class=\"pagination pull-right\" style=\"margin:0px;\">");
			
			if (pageNo > 1){
				sb.append("<li><a href=\"javascript:turnOverPage(")
						.append(pageNo - 1)
						.append(")\">«</a></li>\r\n");
			}

			int start = 1;
			if (pageNo > 4) {
				start = pageNo - 1;
				sb.append("<li><a href=\"javascript:turnOverPage(1)\">1</a></li>\r\n");
				sb.append("<li><a href=\"javascript:turnOverPage(2)\">2</a></li>\r\n");
				sb.append("<li><a href=\"javascript:void(0)\">&hellip;</a></li>\r\n");
			}

			int end = pageNo + 1;
			if (end > totalPages) {
				end = totalPages;
			}
			for (int i = start; i <= end; i++) {
				if (pageNo == i)
					sb.append("<li class=\"active\"><a href=\"javascript:void(0)\">").append(i)
							.append("</a></li>\r\n");
				else {
					sb.append("<li><a href=\"javascript:turnOverPage(").append(i)
							.append(")\">").append(i).append("</a></li>\r\n");
				}
			}

			if (end < totalPages - 2) {
				sb.append("<li><a href=\"javascript:void(0)\">&hellip;</a></li>\r\n");
			}
			if (end < totalPages - 1) {
				sb.append("<li><a href=\"javascript:turnOverPage(")
						.append(totalPages - 1).append(")\">")
						.append(totalPages - 1).append("</a></li>\r\n");
			}
			if (end < totalPages) {
				sb.append("<li><a href=\"javascript:turnOverPage(")
						.append(totalPages).append(")\">").append(totalPages)
						.append("</a></li>\r\n");
			}

			if (pageNo < totalPages) {
				sb.append("<li><a href=\"javascript:turnOverPage(")
						.append(pageNo + 1)
						.append(")\">»</a></li>\r\n");
			}
			sb.append("</ul>");
			sb.append("</form>\r\n");

			sb.append("<script language=\"javascript\">\r\n");
			sb.append("  function turnOverPage(no){\r\n");
			sb.append("    if(!isNaN(no)&&no>0){\r\n");
			sb.append("      if(no>").append(totalPages).append("){");
			sb.append("no=").append(totalPages).append(";}\r\n");
			sb.append("      if(no<1){no=1;}\r\n");
			sb.append("      document.getElementById('" + id + "').pageNo.value=no;\r\n");
			sb.append("      document.getElementById('" + id + "').submit();\r\n");
			sb.append("    }\r\n");
			sb.append("  }\r\n");
			sb.append("</script>\r\n"); 
			
			sb.append("<div class=\"pull-right\" style=\"margin: 7px 8px\">共&nbsp;<strong>")
				.append(totalElements)
				.append("</strong>&nbsp;项").append(",&nbsp;<strong>").append(totalPages)
				.append("</strong>&nbsp;页</div>");
			
			sb.append("<div class=\"pull-right input-group\" style=\"width: 100px;\">");
			sb.append("<input type=\"text\" class=\"form-control\" id=\"pageNoGo\">");
			sb.append("<span class=\"input-group-btn\">");
			sb.append("<a class=\"btn btn-primary\" href=\"javascript:turnOverPage($(\'#pageNoGo\').val())\">Go</a>");
			sb.append("</span>");
			sb.append("</div>");
		}
		
		try {
			this.pageContext.getOut().write(sb.toString());
			this.pageContext.getOut().flush();
		} catch (IOException e) {
			throw new JspException(e);
		}
		return 0;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the totalElements
	 */
	public int getTotalElements() {
		return totalElements;
	}

	/**
	 * @param totalElements the totalElements to set
	 */
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
}


