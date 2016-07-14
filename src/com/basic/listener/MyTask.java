package com.basic.listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;  
import java.util.Date;
import java.util.TimerTask;  

import javax.servlet.ServletContext;

public class MyTask extends TimerTask {
	
	private static final int C_SCHEDULE_HOUR = 0;  
	private static boolean isRunning = false;  
	private ServletContext context = null; 
	
	public MyTask(ServletContext context) {  
		this.context = context;   
	}  
	
	public void run() {
		Calendar c = Calendar.getInstance();  
		if(!isRunning) {  
			//if(C_SCHEDULE_HOUR == c.get(Calendar.HOUR_OF_DAY)) {  
				isRunning = true;  
				context.log("开始执行指定任务");  
				//-------------------开始保存当日历史记录  

				//在这里编写自己的功能，例：  
				//File file = new File("temp");  
				//file.mkdir();  
				//启动tomcat，可以发现在tomcat根目录下，会自动创建temp文件夹  
				
				Date dt = new Date();  
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSSS"); 
		    	//System.out.println(sdf.format(dt));

				String filenameTemp = "D://test//" + sdf.format(dt) + ".txt"; 
				File filename = new File(filenameTemp); 
				if (!filename.exists()) { 
					try {
						filename.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					} 
				} 
				
				System.out.println(filenameTemp+" OK!");
				
				//-------------------结束  
				isRunning = false;  
				context.log("指定任务执行结束");  
			//}  else {
				//System.out.println("还没到开始的时间!");
			//}  
		}  else {  
			context.log("上一次任务执行还未结束");  
		}    
	}  
}