package com.basic.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.basic.pojo.*;
import com.basic.util.DataFormat;

public class Test {

	public static void main(String[] args) throws Exception {
		
		String my = "2017-09-28";

		System.out.println(DataFormat.getDateFormat(my));

		
	}

}
