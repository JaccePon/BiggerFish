/**
 * 解决跨域请求问题
 */
function fetchJSONMap() {
	fetchUp();
}


/**
 * jsonp解决跨域问题
 * 
 * @returns
 */
function jsonpReq(){
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


/**
 * Using fetch to visit service
 * 
 * @returns
 */
function fetchUp(){
	var url="http://127.0.0.1:9879/ajax/jsonMap";
	var formData = new FormData();  
	formData.append("param","admin");  
	  
	fetch(url , {  
		 method: 'POST',  
		 headers: {},
		 body: formData
	}).then((response) => response.json() 
	).then((json) => {  
		alert(JSON.stringify(json));  
	}).catch((error) => {  
		console.log(error);  
	});  
}