package com.web.socket;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.fish.util.FishUtil;
import com.fish.util.JSONUtil;
import com.web.entity.ScoketMsg;

/**
 * websocket实现类
 *
 * <p>
 *
 * @author 3306 2017年9月26日下午9:41:31
 *
 */
@ServerEndpoint(value = "/websocket")
@Controller
public class MyWebSocket {

	/**
	 * 日志对象
	 */
	private static Logger log = LoggerFactory.getLogger(MyWebSocket.class);

	/**
	 * 存放用户对应的session
	 * 
	 * <pre>
	 *	key: 用户名称
	 *
	 *	value: MyWebSocket
	 * </pre>
	 *
	 */
	private static Map<String, MyWebSocket> storageMap = new HashMap<String, MyWebSocket>();

	/**
	 * 用户会话
	 */
	private Session session;

	/**
	 * 在线人数
	 */
	private static int onlineCount = 0;

	/**
	 * 建立成功连接调用方法
	 */
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		addOnlineCounts();
		log.info("Online: " + getOnlineCounts() + " peoples");
	}

	/**
	 * 接收到客户端信息
	 */
	@OnMessage
	public void onMsg(String message, Session session) {
		try {
			ScoketMsg msgEntity = JSONUtil.parse(ScoketMsg.class, message);
			storageMap.put(msgEntity.getFrom(), this);
			if (FishUtil.isEmpty(msgEntity.getText())) {
				return;
			}

			MyWebSocket destSocket = storageMap.get(msgEntity.getTo());
			if (destSocket != null) {
				destSocket.sendMsg(message);
			} else {
				MyWebSocket originSocket = storageMap.get(msgEntity.getFrom());
				msgEntity.setText(msgEntity.getTo() + "'s out of server");
				msgEntity.setFrom("Admin");
				originSocket.sendMsg(msgEntity.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 关闭连接
	 */
	@OnClose
	public void onClose() {
		subOnlineCounts(); // 在线数减1
		log.info("login out");
	}

	/**
	 * 出现异常时
	 * 
	 * @param session
	 *            会话
	 * @param error
	 *            异常对象
	 */
	@OnError
	public void onErr(Session session, Throwable error) {
		error.printStackTrace();
	}

	/**
	 * 发送消息
	 * 
	 * @param msg
	 *            消息主体
	 */
	private void sendMsg(String msg) {
		try {
			if (this.session.isOpen()) {
				this.session.getBasicRemote().sendText(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 广播消息
	 * 
	 * @param msg
	 *            消息
	 */
	public void broadcast(String msg) {
		try {
			storageMap.forEach((from, mysc) -> {
				mysc.sendMsg(msg);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 在线数量自加1
	 */
	public synchronized void addOnlineCounts() {
		onlineCount++;
	}

	/**
	 * 在线数量自减1
	 */
	public synchronized void subOnlineCounts() {
		onlineCount--;
	}

	/**
	 * 获取在线人数
	 * 
	 * @return
	 */
	public synchronized int getOnlineCounts() {
		return onlineCount;
	}
}
