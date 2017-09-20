/**
 * 解决跨域请求问题
 */
function fetchJSONMap() {
	$.ajax({
		url : 'http://127.0.0.1:9879/ajax/jsonMap',
		data : {
			param : "ask for map"
		},
		method : "post",
		dataType : "jsonp",
		jsonp : "callback",// 回调参数
		success : function(data) {
		}
	});
}

/**
 * 获取返回值处理方法
 * 
 * @param data
 *            返回值
 */
function callback(data) {
	console.log(data);
	console.log(data.project);
}
