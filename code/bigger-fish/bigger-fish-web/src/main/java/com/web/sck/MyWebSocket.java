package com.web.sck;

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

import com.fish.util.JSONUtil;
import com.web.entity.ScoketMsg;

@ServerEndpoint(value = "/websocket")
@Controller
public class MyWebSocket {

	private static Logger log = LoggerFactory.getLogger(MyWebSocket.class);

	private static Map<String, MyWebSocket> storageMap = new HashMap<String, MyWebSocket>();

	private Session session;

	private static int onlineCount = 0;

	/**
	 * 建立成功连接调用方法
	 */
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		addOnlineCounts();

		log.info("Online: " + getOnlineCounts() + " peoples");

		sendMsg("It's so nice to meet you :\")");
	}

	/**
	 * 接收到客户端信息时
	 */
	@OnMessage
	public void onMsg(String message, Session session) {
		try {
			ScoketMsg msgEntity = JSONUtil.parse(ScoketMsg.class, message);
			storageMap.put(msgEntity.getFrom(), this);

			MyWebSocket targetSc = storageMap.get(msgEntity.getTo());

			if (targetSc != null) {
				targetSc.sendMsg(message);
			} else {
				log.info("The " + msgEntity.getTo() + " is out of server");
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
			this.session.getBasicRemote().sendText(msg);
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
