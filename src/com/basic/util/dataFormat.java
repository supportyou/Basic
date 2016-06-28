package com.basic.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataFormat {
  public DataFormat() {  }

  public static String toHtml(String s) {
    if (s==null) return s;
    s=strReplace(s,"&","&amp;");
    s=strReplace(s,"<","&lt;");
    s=strReplace(s,">","&gt;");
    s=strReplace(s,"\"","&quot;");
    
    s=strReplace(s,"\r\n","\n");
    s=strReplace(s,"\n","<br>\n");
    s=strReplace(s,"\t","	");
    
    //s=parseReturn(s,"<br>\n&nbsp;&nbsp;&nbsp;&nbsp;");
    return s;
  }
  
  public static String toHtml1(String s) {
    if (s==null) return s;
    s=strReplace(s,"&","&amp;");
    s=strReplace(s,"<","&lt;");
    s=strReplace(s,">","&gt;");
    s=strReplace(s,"\"","&quot;");
    
    s=strReplace(s,"\r\n","\n");
    
    s=strReplace(s,"\t","	");
    
    //s=parseReturn(s,"<br>\n&nbsp;&nbsp;&nbsp;&nbsp;");
    return s;
  }
  
  public static String strReplace(String sBody, String sFrom, String sTo) {
     int i,j,k,l;
     if (sBody==null || sBody.equals("")) return "";
     i = 0;
     j = sFrom.length();
     k = sTo.length();
     StringBuffer sss = new StringBuffer(sBody.length());
     boolean bFirst=true;
     l = i;
     while (sBody.indexOf(sFrom,i)!=-1) {
       i = sBody.indexOf(sFrom,i);
       sss.append(sBody.substring(l,i));
       sss.append(sTo);
       i += j;
       l = i;
     }
     sss.append(sBody.substring(l));
     return sss.toString();
   }


  public static String parseReturn(String sBody, String sEndwith) {
     StringTokenizer t = new StringTokenizer(sBody, "\r\n");
     StringBuffer sss = new StringBuffer(sBody.length());
     boolean bFirst=true;
     if (sEndwith.trim().equals("")) sEndwith="\n";
     while (t.hasMoreTokens()) {
        String s=t.nextToken();
        s=s.trim();
        while (s.startsWith("��")) s=s.substring(2);
        if (!s.equals("")) {
           if (bFirst) {
           	bFirst=false;
          } else {
            sss.append(sEndwith);
          }
        sss.append(s);
       }
      }
      return sss.toString();
  }


  public static String toHtmlInput(String str) {
 	 if (str == null)    return null;
    String html = new String(str);
    html = strReplace(html, "&", "&amp;");
    html = strReplace(html, "<", "&lt;");
    html = strReplace(html, ">", "&gt;");
    return html;
 }

 
 public static String toString(String str) {
	 if(str==null)str = "";
	 if(str.equals("null"))str = "";
	 str = str.trim();
	 return str;
 }


 public static String getGbk( String str) {
	 try
		 {
	 		if (str==null || str.equals("")) {
	 			str="";
	 			return str;
	 		} else {
	 			return new String(str.getBytes("ISO8859-1"),"UTF-8");
	 		} 
		 }
		 catch (Exception e)
		 {
			 	return str;
		 }
 }


 public static String toNewCode( String str) {
	 try
		 {
	 		if (str==null || str.equals("")) {
	 			str="";
	 			return str;
	 		} else {
	 			return new String(str.getBytes("ISO8859-1"),"UTF-8");
	 		} 
		 }
		 catch (Exception e)
		 {
			 	return str;
		 }
}  


 public static String toDirCN( String str) {
	 try
		 {
	 		if (str==null || str.equals("")) {
	 			str="";
	 			return str;
	 		} else {
	 			return new String(str.getBytes("ISO8859-1"));
	 		} 
		 }
		 catch (Exception e)
		 {
			 	return str;
		 }
}  


 public static String toSql(String str) {
 	 str = toString(str);
    String sql = new String(str);
    //sql = getGbk(toString(sql));
    return strReplace(sql, "'", "''");
 }


  public static String rightcut(String source, int len, String delim) {
	if (source == null) return null;
	int start, stop , byteLen ;
	int alen = source.getBytes().length;

	if (len > 0) {
		if (alen <= len) return source;
		start = stop = byteLen = 0; 
		
		while ( byteLen <= len){
			if ( source.substring(stop,stop+1).getBytes().length == 1){
				byteLen += 1 ;
			}else{
				byteLen += 2 ;
			}
			stop++;
		}
		StringBuffer sb = new StringBuffer(source.substring(start, stop-1));
		if (alen > len) sb.append(delim);
		return sb.toString();
	}
	start = (len < -alen ? 0 : alen + len);
	stop = alen;
	StringBuffer sb = new StringBuffer(source.substring(start/2, stop/2));
	if (-alen <= len) sb.insert(0, delim);
	return sb.toString();
 }


  public static String getDateTime() {
  	SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  	String time=f.format(new Date());
  	return time;
  }
  
  public static String getmyYear() {
    java.util.Calendar mynow=null;
    mynow=mynow.getInstance();
    String myYear=String.valueOf(mynow.get(mynow.YEAR));
    return myYear;
  }
  
  public static String getmyMonth() {
    java.util.Calendar mynow=null;
    mynow=mynow.getInstance();
    String myMonth=String.valueOf(mynow.get(mynow.MONTH)+1);
    if (myMonth.length()==1) { myMonth="0"+myMonth; }
    return myMonth;
  }
  
  public static String getmyDay() {
    java.util.Calendar mynow=null;
    mynow=mynow.getInstance();
    String myDay=String.valueOf(mynow.get(mynow.DATE));
    if (myDay.length()==1) { myDay="0"+myDay; }
    return myDay;
  }
  
  public static String getmyHour() {
    java.util.Calendar mynow=null;
    mynow=mynow.getInstance();
    String myHour=String.valueOf(mynow.get(mynow.HOUR));
    if (myHour.length()==1) { myHour="0"+myHour; }
    return myHour;
  }
  
  public static String getmyMinute() {
    java.util.Calendar mynow=null;
    mynow=mynow.getInstance();
    String myMinute=String.valueOf(mynow.get(mynow.MINUTE));
    if (myMinute.length()==1) { myMinute="0"+myMinute; }
    return myMinute;
  }  
  
  public static String getmySecond() {
    java.util.Calendar mynow=null;
    mynow=mynow.getInstance();
    String mySecond=String.valueOf(mynow.get(mynow.SECOND));
    if (mySecond.length()==1) { mySecond="0"+mySecond; }
    return mySecond;
  }  
  
  public static String getmyToday() {
    String myToday=getmyYear()+"-"+getmyMonth()+"-"+getmyDay();
    return myToday;
  }
  
  
  
  
  public static String getmyFNDB(double db) {
	DecimalFormat df=new DecimalFormat("#0.000");
	//return Double.parseDouble(df.format(db));
	return df.format(db);
  }

  
  public static int getmyFNInt(double db) {
	DecimalFormat df=new DecimalFormat("0");
	return (Integer.parseInt(df.format(db)));
  }   
  
  //Remain 2, ex: 12345.68
  public static String getmyFN(double db) {
	DecimalFormat df=new DecimalFormat("0.00");
	return df.format(db);
  }
  
  //Remain 2, ex: 12,345.68
  public static String getmyFNDisplay(String str) {
  	NumberFormat nf=NumberFormat.getInstance();
  	nf.setMinimumFractionDigits(2);
	//return nf.format(Float.parseFloat(str));
  	return nf.format(Double.parseDouble(getmyFN(Double.parseDouble(str))));
  }
  
  
  public static String getDate() {
  	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd",Locale.US);
  	String date=sdf.format(new Date());
  	return date;
  }
  
  public static String getDate7(String strnowdate, String type, int multiple) {
  	String date7="";
  	int day=0;
  	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd",Locale.US);
  	Calendar cl=Calendar.getInstance(); 
  	
  	if (strnowdate!=null && !strnowdate.equals("")) {
  		try {
  			cl.setTime(sdf.parse(strnowdate));
  		} catch (Exception e) {}
  	} else {
  		cl.setTime(new Date());
  	}
  	
	day=cl.get(Calendar.DAY_OF_YEAR);
	if (type=="Previous") {
		cl.set(Calendar.DAY_OF_YEAR, day-7*multiple);
	} else if(type=="Next") {
		cl.set(Calendar.DAY_OF_YEAR, day+7*multiple);
	} else {
		cl.set(Calendar.DAY_OF_YEAR, day+0*multiple);
	}
  	
  	date7=String.valueOf(sdf.format(cl.getTime()));
  	
  	return date7;
  }
  
  
  public static String getDateNewFormat(String strolddate) {
  	SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
  	String newdate="";
  	if (!strolddate.equals("")) {
  		newdate=f.format(new Date(strolddate));
  	}
  	return newdate;
  }
  
  public static Date getDateFormat(String strolddate) {
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	if (strolddate==null) strolddate="";
  	Date newDate= null;
  	try  {  
  	   newDate = df.parse(strolddate);  
  	} catch (ParseException e) {  
  	    //System.out.println(e.getMessage());  
  	}  
  	return newDate;
  }
  
  
  public static String getWeekNo(String strnowdate) {
  	String weekno="";
  	int day=0;
  	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd",Locale.US);
  	Calendar cl=Calendar.getInstance();
  	cl.setMinimalDaysInFirstWeek(1);
  	
  	if (strnowdate!=null && !strnowdate.equals("")) {
  		try {
  			cl.setTime(sdf.parse(strnowdate));
  		} catch (Exception e) {}
  	} else {
  		cl.setTime(new Date());
  	}
  	
  	weekno=String.valueOf(cl.get(Calendar.WEEK_OF_YEAR));
  	
  	if (weekno.length()==1) { weekno="0"+weekno; }
  	
  	String weeknoyear="";
  	if (cl.get(Calendar.MONTH)==11 && weekno.equals("01")) {
  		weeknoyear=String.valueOf(cl.get(Calendar.YEAR)+1);
  	} else {
  		weeknoyear=String.valueOf(cl.get(Calendar.YEAR));
  	}
  	
  	weekno=weekno+weeknoyear.substring(2);

  	return weekno;
  }  
  
  
  
  
  public static String getWeekNoXXX(String strnowdate, String type) {
  	String weekno="";
  	int day=0;
  	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd",Locale.US);
  	Calendar cl=Calendar.getInstance();
  	
  	if (strnowdate!=null && !strnowdate.equals("")) {
  		try {
  			cl.setTime(sdf.parse(strnowdate));
  		} catch (Exception e) {}
  	} else {
  		cl.setTime(new Date());
  	}
  	
	day=cl.get(Calendar.DAY_OF_YEAR);
	if (type=="Previous") {
		cl.set(Calendar.DAY_OF_YEAR, day-7);
	} else if(type=="Next") {
		cl.set(Calendar.DAY_OF_YEAR, day+7);
	} else {
		cl.set(Calendar.DAY_OF_YEAR, day+0);
	}
  	
  	weekno=String.valueOf(cl.get(Calendar.WEEK_OF_YEAR));
  	
  	if (weekno.length()==1) { weekno="0"+weekno; }
  	
  	return weekno;
  }
  
  

  public static String getRandomPassword() {
	char mapTable[]={
			'a','b','c','d','e','f',
			'g','h','i','j','k','l',
			'm','n','o','p','q','r',
			's','t','u','v','w','x',
			'y','z','0','1','2','3',
			'4','5','6','7','8','9'};
  
	String strTempPassword = "";

	for(int i=0; i<4; ++i) {
		strTempPassword += mapTable[(int)(mapTable.length*Math.random())];
	} 
	
	return strTempPassword;
  }

}



