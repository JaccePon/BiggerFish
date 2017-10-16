package com.service.rest.chat;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fish.db.JdbcUtil;

/**
 * websocket信息持久化接口
 *
 * <p>
 *
 * @author 3306 2017年10月16日下午10:38:37
 *
 */
@RestController
@RequestMapping("/chat/")
public class WebChatService {

	/**
	 * 新增一条信息
	 * 
	 * @param from
	 *            发送者
	 * @param to
	 *            接收者
	 * @param date
	 *            发送日期
	 * @param msg
	 *            消息主体
	 * @return String
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(String from, String to, String date, String msg) {
		Connection connection = JdbcUtil.getDefMySQLConnection();
		try {
			String sql = "INSERT INTO chat_t(`from`,`to`,`date`,`msg`) VALUES(?,?,?,?)";
			String[] arr = { from, to, date, msg };
			
			PreparedStatement pstm = JdbcUtil.buildPreparedStatement(connection, sql, arr);
			pstm.executeUpdate();
			pstm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
