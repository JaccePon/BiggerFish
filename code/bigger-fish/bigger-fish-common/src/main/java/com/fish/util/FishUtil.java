package com.fish.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 简单工具类
 * <p>
 * 
 * @author 3306 2017年9月18日
 * @see
 * @since 1.0
 */
public class FishUtil {

	/**
	 * 判断字符串是否不为空
	 *
	 * @param str
	 *            字符串
	 * @return boolean
	 */
	public static boolean isNotEmpty(String str) {
		return isEmpty(str) ? false : true;
	}

	/**
	 * 判断字符串是否为空,空则返回true
	 *
	 * @param str
	 *            字符串
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return null == str || "".equals(str.trim());
	}

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

	/**
	 * 创建Map
	 *
	 * @return HashMap
	 */
	public static <K, V> Map<K, V> buildMap() {
		return new HashMap<>();
	}

	/**
	 * 创建List
	 *
	 * @return ArrayList
	 */
	public static <T> List<T> buildList() {
		return new ArrayList<T>();
	}

	/**
	 * 创建Set
	 *
	 * @return HashSet
	 */
	public static <T> Set<T> buildSet() {
		return new HashSet<T>();
	}

	/**
	 * 判断collection是否为空,如果为空返回true
	 *
	 * @param listOrSet
	 *            集合list或者set元素
	 * @return boolean
	 */
	public static <T> boolean isEmpty(Collection<T> listOrSet) {
		return null == listOrSet || listOrSet.isEmpty();
	}

	/**
	 * 判断Map是否为空
	 *
	 * @param map
	 *            Map
	 * @return boolean
	 */
	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return null == map || 0 == map.size();
	}

	/**
	 * 判断数组是否为空
	 *
	 * @param arr
	 *            数组
	 * @return boolean
	 */
	public static <T> boolean isEmpty(T[] arr) {
		return null == arr || 0 == arr.length;
	}

	/**
	 * 将数组转换成List
	 *
	 * @param arr
	 *            数组
	 * @return List
	 */
	public static <T> List<T> toList(T[] arr) {
		if (null == arr || 0 == arr.length) {
			return Collections.emptyList();
		}

		List<T> list = buildList();
		for (T each : arr) {
			list.add(each);
		}
		return list;
	}

}
