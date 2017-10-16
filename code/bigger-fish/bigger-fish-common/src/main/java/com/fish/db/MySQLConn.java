package com.fish.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * mysql连接
 *
 * <p>
 *
 * @author 3306 2017年10月16日下午10:31:50
 *
 */
class MySQLConn implements GetConnection {

	@Override
	public Connection getConnection(ConnEntity entity) {
		Connection conn = null;
		try {

			Class.forName(entity.getDriverName());
			conn = DriverManager.getConnection(entity.getUrl(), entity.getUser(), entity.getPassword());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
