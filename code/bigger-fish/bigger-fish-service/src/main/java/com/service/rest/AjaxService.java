package com.service.rest;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fish.util.JSONUtil;
import com.service.entity.Movie;

/**
 * 测试跨域请求
 *
 * <pre>
 * POST /uri 创建 <br/>
 * DELETE /uri/xxx 删除 <br/>
 * PUT /uri/xxx 更新或创建<br/>
 * GET /uri/xxx 查看
 * </pre>
 * 
 * @author 3306 2017年9月21日下午8:53:16
 *
 */
@RestController
@RequestMapping("/ajax")
public class AjaxService {

	private static Logger LOG = LoggerFactory.getLogger(AjaxService.class);

	/**
	 * 测试Ajax返回json字符串
	 * 
	 * @param ask
	 *            请求参数
	 * @return String
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/getAjax/{ask}")
	@ResponseBody
	public String get(@PathVariable String ask) {

		LOG.info("The param is: " + ask);

		Map<String, String> map = new HashMap<String, String>();
		map.put("project", "bigger-fish");
		map.put("leader", "JaccePon");
		map.put("dev", "3306");
		map.put("ask", ask);

		return JSONUtil.toJSONStr(map);
	}

	/**
	 * 测试Ajax使用DELETE
	 * 
	 * @param ask
	 *            请求参数
	 * @return String
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/delAjax/{ask}")
	@ResponseBody
	public String delete(@PathVariable String ask) {

		LOG.info("The delete param is: " + ask);

		Map<String, String> map = new HashMap<String, String>();
		map.put("project", "bigger-fish");
		map.put("leader", "JaccePon");
		map.put("dev", "3306");
		map.put("ask", ask);

		return JSONUtil.toJSONStr(map);
	}

	/**
	 * 测试Ajax使用PUT
	 * 
	 * @param ask
	 *            请求参数
	 * @return String
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/addAjax")
	@ResponseBody
	public String add(Movie movie) {

		LOG.info("The add param is: " + movie);

		Map<String, String> map = new HashMap<String, String>();
		map.put("project", "bigger-fish");
		map.put("leader", "JaccePon");
		map.put("dev", "3306");
		map.put("ask", movie.toString());

		return JSONUtil.toJSONStr(map);

	}

	/**
	 * 测试Ajax使用POST
	 * 
	 * @param movie
	 *            {@link Movie}
	 * @return String
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/postAjax")
	@ResponseBody
	public String post(Movie movie) {

		LOG.info("The post param is: " + movie);

		Map<String, String> map = new HashMap<String, String>();
		map.put("project", "bigger-fish");
		map.put("leader", "JaccePon");
		map.put("dev", "3306");
		map.put("ask", movie.toString());

		return JSONUtil.toJSONStr(map);

	}
}
