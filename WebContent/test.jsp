<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>  
<%  
//驱动程序名  
String driverName = "com.mysql.jdbc.Driver";  
//数据库用户名  
String userName = "hdm174585450";  
//密码  
String userPasswd = "verygood88";  
//数据库名  
String dbName = "hdm174585450_db";
//表名  
String tableName = "student";  
//联结字符串  
String url = "jdbc:mysql://hdm174585450.my3w.com:3306/" + dbName + "?user=" + userName + "&password=" + userPasswd;  
//加载驱动  
Class.forName("com.mysql.jdbc.Driver").newInstance();  
//建立连接  
Connection conn = DriverManager.getConnection(url);     
//创建Statement（负责执行sql语句）  
Statement stmt = conn.createStatement();  
String sql="select * from " + tableName;  
//获得数据结果集合  
ResultSet rs = stmt.executeQuery(sql);  
//依次遍历结果集（表中的记录）  
while(rs.next())  
{  
    //依据数据库中的字段名打印数据  
    out.println(rs.getString("userName"));  
    out.println(rs.getString("sex"));  
    out.println(rs.getString("degree"));  
    out.println("-------------------");
}  
//关闭连接  
rs.close();  
stmt.close();  
conn.close();  
%>