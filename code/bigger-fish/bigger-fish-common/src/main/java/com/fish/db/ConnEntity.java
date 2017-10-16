package com.fish.db;

import com.fish.util.JSONUtil;

/**
 * 数据库连接实体类
 *
 * <p>
 *
 * @author 3306 2017年10月16日下午10:17:48
 *
 */
public class ConnEntity {

	/**
	 * 连接驱动名称
	 */
	private String driverName;

	/**
	 * 数据库连接url
	 */
	private String url;

	/**
	 * 数据库用户
	 */
	private String user;

	/**
	 * 数据库登录密码
	 */
	private String password;

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return JSONUtil.toJSONStr(this);
	}

}
