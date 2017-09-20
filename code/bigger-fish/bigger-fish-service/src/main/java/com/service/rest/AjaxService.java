package com.service.rest;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fish.util.JSONUtil;

@RestController
@RequestMapping("/ajax")
public class AjaxService {

	private static Logger LOG = LoggerFactory.getLogger(AjaxService.class);

	/**
	 * 测试Ajax返回json字符串
	 * 
	 * @param param
	 *            请求参数
	 * @return String
	 */
	@RequestMapping("/jsonMap")
	@ResponseBody
	public String getJsonMap(String param) {

		LOG.info("The param is: " + param);

		Map<String, String> map = new HashMap<String, String>();
		map.put("project", "bigger-fish");
		map.put("leader", "JaccePon");
		map.put("dev", "3306");

		return JSONUtil.buildCallbackJSONStr(map);
	}

}
