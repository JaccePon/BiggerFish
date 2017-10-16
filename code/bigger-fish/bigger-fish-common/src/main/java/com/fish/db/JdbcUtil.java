package com.fish.db;

import java.sql.Connection;

public class JdbcUtil {

	public static enum Type {
		/**
		 * mysql
		 */
		mysql,
		/**
		 * oracle
		 */
		oracle,
		/**
		 * other
		 */
		other
	}

	private JdbcUtil() {

	}

	/**
	 * 获取数据库连接
	 * 
	 * @param db
	 *            数据库类型 {@link Type}
	 * @param entity
	 *            连接参数
	 * @return Connection
	 */
	public static Connection getConnection(Type db, ConnEntity entity) {

		GetConnection conn = null;
		switch (db) {
		case mysql:
			conn = new MySQLConn();
			break;
		default:
			break;

		}

		return null == conn ? null : conn.getConnection(entity);
	}

}
