package com.basic.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.basic.pojo.*;

public class Test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		//String my="我的 文件";
		
		//String my1=null;
		//String myutf8 = null;
		//String myiso=null;
		
		
		
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//if (null != my && !"".equals(my)) {
			//System.out.println(df.parse(my));
		//}
		//try {  
			//my1=new String(my.getBytes("ISO8859-1"),"UTF-8");
			//myutf8  = new String(my .getBytes(), "UTF-8");
			//myiso  = new String(my .getBytes(), "ISO8859-1");
        //} catch (Exception e) {  
        //}  
		
		//System.out.println(my.getBytes());
		//System.out.println(my1);
		//System.out.println(myutf8);
		//System.out.println(myiso);

		//Date dt = new Date();  
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSSS"); 
		
		//System.out.println(sdf.format(dt));
		
		//String  fielName = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %1$tL",new Date())+".txt";
	    ///System.out.println(fielName); 
		
	  	//SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  	//SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy",Locale.US);
	  	//String time=f.format(new Date());
	  	//return time;
		
		List<String> list1= new ArrayList<String>();
		List<String> list2= new ArrayList<String>();
		
	
		
		
		for (int i = 0; i < 5; i++) {
			Student student = new Student();
			String my="A"+i;
			list1.set(i, my);
			list2.set(i, my);
			//list1.add(my);
			//list2.add(my);
			System.out.println("OK");
		}

		
		
	}

}
