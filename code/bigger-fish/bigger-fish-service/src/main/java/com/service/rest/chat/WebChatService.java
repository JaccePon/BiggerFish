package com.service.rest.chat;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fish.db.ConnEntity;
import com.fish.db.JdbcUtil;
import com.service.util.Const;

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
		ConnEntity entity = new ConnEntity();
		entity.setDriverName(Const.MYSQL_DRIVER);
		entity.setUrl(Const.MYSQL_URL);
		entity.setUser(Const.MYSQL_USER);
		entity.setPassword(Const.MYSQL_PASSWORD);

		Connection connection = JdbcUtil.getConnection(JdbcUtil.Type.mysql, entity);
		try {
			String sql = "INSERT INTO chat_t(`from`,`to`,`date`,`msg`) VALUES(?,?,?,?)";
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, from);
			pstm.setString(2, to);
			pstm.setString(3, date);
			pstm.setString(4, msg);

			pstm.executeUpdate();

			pstm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

}
