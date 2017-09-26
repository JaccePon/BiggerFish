package com.web.entity;

import com.fish.util.JSONUtil;

/**
 * WebSocket 消息实体类
 * 
 * @author 3306 2017年9月26日下午3:54:14
 *
 */
public class ScoketMsg {

	/**
	 * 发送消息用户名称
	 */
	private String from;

	/**
	 * 接收至用户名称
	 */
	private String to;

	/**
	 * 时间
	 */
	private String date;

	/**
	 * 消息内容
	 */
	private String text;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return JSONUtil.toJSONStr(this);
	}
}
