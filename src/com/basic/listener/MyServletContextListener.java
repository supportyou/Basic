package com.basic.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 应用上下文生命周期监听器，主要是在上下文初始化的过程，对本程序中的数据做一些初始化工作
 */
public class MyServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyServletContextListener() {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
    	String ctx = event.getServletContext().getContextPath(); //web应用上下文根路径-->虚拟目录
    	event.getServletContext().setAttribute("ctx", ctx);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event) {
    }
}
