package com.fish.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期辅助类
 * 
 * @author 3306 2017年9月27日下午7:27:50
 *
 */
public class DateUtil {
	/**
	 * 获取当前日期字符串
	 *
	 * @return String
	 */
	public static String getCurrentTime() {
		return getFormatDate("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 日期格式
	 *
	 * @param format
	 *            日期格式字符串,如yyyy-MM-dd HH:mm:ss
	 * @return String
	 */
	public static String getFormatDate(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);

		return dateFormat.format(new Date());
	}

}
