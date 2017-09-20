package com.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Web startup
 *
 * <p>
 *
 * @author 3306 2017年9月18日下午11:04:46
 *
 */
@SpringBootApplication
public class WebApp {

	private static final Logger LOG = LoggerFactory.getLogger(WebApp.class);

	/**
	 * 启动App
	 * 
	 * @param args
	 *            启动参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(WebApp.class, args);
		LOG.info("Start WebApp success");
	}

}
