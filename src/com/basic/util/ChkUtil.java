/**
 * ChkUtil.java
 * Copyright (C) 2010 SLMS
 * Simple Logistics Management System
 * 
 */
package com.basic.util;

/**
 * @ClassName: ChkUtil
 * @Description: TODO(成都商会楷码OA开发)
 * @author 秦有龙
 * @date 2012-9-12 上午10:23:21
 *
 */
public class ChkUtil {
	/**
	 * 验证是否为空
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNullOrEmpty(Object value) {
		if (value == null || String.valueOf(value).trim().length() < 1) {
			return true;
		}
		return false;

	}
}
