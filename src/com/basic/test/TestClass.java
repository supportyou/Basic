package com.basic.test;

import java.lang.reflect.ParameterizedType;
import java.util.UUID;

import com.basic.base.BaseDao;;

public class TestClass {
    public static void main(String[] args) {
    	
    	BaseDao bd=new BaseDao();
    	System.out.println(bd.getClass());
		
    }
}