package com.basic.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.basic.pojo.Student;
import com.basic.dao.impl.*;
 
public class StudentTest {
 
    public static void main(String[] args){
        Student s = new Student();
        s.setUserName("Shixin");
        s.setSex("Man");
        s.setRemark("This is a test! 这是一个测试");
         
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure().buildSessionFactory();
         
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();
        session.close();
        sf.close();
        
        System.out.println("Success!");
    }
}