package com.basic.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.basic.pojo.*;
 
public class UseridTest {
 
    public static void main(String[] args){
        User u = new User();
        u.setEmail("Rock");
        u.setPassword("953953");
         
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure().buildSessionFactory();
         
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        session.close();
        sf.close();
        
        System.out.println("Success!");
    }
}