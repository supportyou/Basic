/**
 * FileName:     CheckCodeService.java
 * CreationDate: 2014年4月30日
 * Author:       qiujy
 * EMail:        qjyong@gmail.com
 * Site:         http://www.itvk.cn
 * CopyRight: ITVK.CN All Recieves.
 */
package com.basic.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;


/**
 * 生成验证码的业务类
 */
@Service
//@Scope(value="prototype")
public class CheckCodeService {
	private static String[] src = {"A", "B", "C", "D", "E", "F", "G", "H", "J", 
		"K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", 
		"Z", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	private Random random = new Random();
	
	public CheckCodeService(){}
	
	
	public String randomString(int num){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < num; i++){
			int index = random.nextInt(src.length); //[0, src.lenth)
			sb.append(src[index]);
		}
		
		return sb.toString();
	}
	
	/**
	 * 根据src字符串产生一个指定宽度和指定高度的图片，并输出到指定的输出流中
	 * @param src 源字符串
	 * @param out 目标输出流
	 * @param width 宽度（px）
	 * @param height 高度
	 * @throws IOException
	 */
	public void renderImage(String src, OutputStream out, int width, int height) throws IOException{
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g = (Graphics2D)img.getGraphics();
		
		//画背景
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		//画边框
		//g.setColor(Color.BLACK);
		//g.drawRect(0, 0, width-1, height-1);
		
		//画字符串
		g.setColor(randColor(10, 255));
		g.setFont(new Font("Arial", Font.BOLD, 26));
		
		g.drawString(src, 12, height - 7);

		//画干扰圈
		for(int i=0;i<10;i++){
	    	g.setColor(randColor(150, 250));
	    	g.drawOval(random.nextInt(width-10), random.nextInt(height-10), 
	    			5+random.nextInt(10), 5+random.nextInt(10));
	    }
		
		ImageIO.write(img, "png", out);
	}
	
	private Color randColor(int min, int max){
		if(min > 255){
			min = 255;
		}
		if(max > 255){
			max = 255;
		}
		int r = min + random.nextInt(max - min);
		int g = min + random.nextInt(max - min);
		int b = min + random.nextInt(max - min);
		
		return new Color(r, g, b);
	}
}