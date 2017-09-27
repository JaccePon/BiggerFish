var websocket = null;

/**
 * 判断当前浏览器是否支持websocket
 */
if ('WebSocket' in window) {
	websocket = new WebSocket(websocketServerUrl);
} else {
	alert('Not support websocket')
}

/**
 * 连接发生错误的回调方法
 */
websocket.onerror = function() {
	setMessageInnerHTML("error");
};

/**
 * 连接成功建立的回调方法
 * 
 * 第一次发送,确认用户和session关系
 */
websocket.onopen = function(event) {
	send();
}

/**
 * 接收到消息的回调方法
 */
websocket.onmessage = function(event) {
	setReceiveMsgHtml(event.data);
}

/**
 * 连接关闭的回调方法
 */
websocket.onclose = function() {
	// do something
}
/**
 * 监听窗口关闭事件
 * 
 * 当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
 */
window.onbeforeunload = function() {
	websocket.close();
}

/**
 * 将消息显示在网页上
 * 
 * @param innerHTML
 *            消息
 */
function setMessageInnerHTML(innerHTML) {

	if (null == innerHTML || '' == innerHTML.trim()) {
		return;
	}

	document.getElementById('message').innerHTML += innerHTML + '<br/>';
}

/**
 * 设置显示发送消息
 * 
 * @param msgEntity
 */
function setPostMsgHtml(msgEntity) {
	var entity = JSON.parse(msgEntity);
	var html = "<div class=\"panel panel-info from\">";
	html += "<div class=\"panel-heading\">";
	html += entity.from;
	html += "&nbsp;&nbsp;";
	html += entity.date;
	html += "</div>";
	html += "<div class=\"panel-body\">";
	html += entity.text;
	html += "</div>";
	html += "</div>";

	$(".chat-area").append(html);
}

/**
 * 显示接收信息
 * 
 * @param msgEntity
 *            信息类
 */
function setReceiveMsgHtml(msgEntity) {
	var entity = JSON.parse(msgEntity);
	var html = "<div class=\"panel  panel-success to\">";
	html += "<div class=\"panel-heading\">";
	html += entity.from;
	html += "&nbsp;&nbsp;";
	html += entity.date;
	html += "</div>";
	html += "<div class=\"panel-body\">";
	html += entity.text;
	html += "</div>";
	html += "</div>";

	$(".chat-area").append(html);
}

/**
 * 关闭连接
 */
function closeWebSocket() {
	websocket.close();
}

document.onkeydown = function(event) {
	var e = event || window.event || arguments.callee.caller.arguments[0];
	if (e && e.keyCode == 13) { // enter 键
		send();
		$("#text").val("");
	}
};

/**
 * 发送消息
 */
function send() {
	var msg = new Object();
	msg.to = $("#to").val();
	msg.from = $("#from").val()
	msg.text = $("#text").val()
	msg.date = getFormatDate();

	if (msg.text == '') {
		return;
	}

	setPostMsgHtml(JSON.stringify(msg));

	// 将消息封装成json数据发送
	websocket.send(JSON.stringify(msg));
}