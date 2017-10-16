package com.fish.db;

import java.sql.Connection;

/**
 * 获取数据库连接工厂接口
 *
 * <p>
 *
 * @author 3306 2017年10月16日下午10:16:11
 *
 */
interface GetConnection {

	/**
	 * 获取数据库连接
	 * 
	 * @param entity
	 *            连接参数
	 * @return Connection
	 */
	public Connection getConnection(ConnEntity entity);
}
