package com.fish.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import com.fish.util.Const;
import com.fish.util.FishUtil;

/**
 * JDBC工具类
 *
 * <p>
 *
 * @author 3306 2017年10月16日下午11:17:44
 *
 */
public class JdbcUtil {

	private static Map<String, GetConnection> storage = FishUtil.buildMap();

	private JdbcUtil() {

	}

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

	/**
	 * 获取MYSQL连接,默认使用{@link Const}配置
	 * 
	 * @return Connection
	 */
	public static Connection getDefMySQLConnection() {

		ConnEntity entity = new ConnEntity();
		entity.setDriverName(Const.MYSQL_DRIVER);
		entity.setUrl(Const.MYSQL_URL);
		entity.setUser(Const.MYSQL_USER);
		entity.setPassword(Const.MYSQL_PASSWORD);

		return getConnection(Type.mysql, entity);

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
		String key = db.getClass().getName();
		GetConnection conn = storage.get(key);
		if (null == conn) {
			switch (db) {
			case mysql:
				conn = new MySQLConn();
				break;
			default:
				break;
			}
			storage.put(db.getClass().getName(), new MySQLConn());
		}
		return null == conn ? null : conn.getConnection(entity);
	}

	/**
	 * 建立PrepareStatement
	 * 
	 * @param conn
	 *            Connection对象
	 * @param sql
	 *            sql语句
	 * @param vals
	 *            参数值
	 * @return {@link PreparedStatement}
	 */
	public static <T> PreparedStatement buildPreparedStatement(Connection conn, String sql,
			@SuppressWarnings("unchecked") T... vals) {
		if (null == conn) {
			throw new IllegalArgumentException("The connection of database must not be null");
		}

		if (!isLegalSqlAndParams(sql, vals.length)) {
			throw new IllegalArgumentException("The parameter's length must equal your sql parameter's length");
		}

		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			for (int index = 0, len = vals.length; index < len; index++) {
				pstm.setString(index + 1, vals[index].toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pstm;
	}

	/**
	 * 判断sql里面的?是否等于val的长度
	 * 
	 * @param sql
	 *            sql数据
	 * @param lengthOfParams
	 *            参数长度
	 * @return boolean
	 */
	private static boolean isLegalSqlAndParams(String sql, int lengthOfParams) {
		int len = 0;
		for (char ch : sql.toCharArray()) {
			if (ch == '?') {
				len++;
			}
		}
		return len == lengthOfParams;
	}

}
