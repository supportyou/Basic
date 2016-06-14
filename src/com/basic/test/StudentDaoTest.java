package com.basic.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.basic.action.StudentAction;
 
public class StudentDaoTest {
 
    public static void main(String[] args){
        
        StudentAction sa = new StudentAction();
        
        sa.save();
        
        System.out.println("Success!");
    }
}