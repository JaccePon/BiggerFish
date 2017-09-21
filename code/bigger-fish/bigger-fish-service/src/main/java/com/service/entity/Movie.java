package com.service.entity;

import com.fish.util.JSONUtil;

/**
 * 电影实体类
 *
 * <p>
 *
 * @author 3306 2017年9月21日下午10:26:00
 *
 */
public class Movie {
	/*
	 * 名称
	 */
	private String name;

	/*
	 * 发行日期
	 */
	private String date;

	/*
	 * 评分
	 */
	private float score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return JSONUtil.toJSONStr(this);
	}

}
