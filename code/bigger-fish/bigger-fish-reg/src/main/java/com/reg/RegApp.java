package com.reg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * The register center of spring cloud
 *
 * <p>
 *
 * @author 3306 2017年9月19日下午10:03:03
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class RegApp {

	private static Logger log = LoggerFactory.getLogger(RegApp.class);

	/**
	 * 启动注册中心
	 * 
	 * @param args
	 *            Spring cloud参数,如激活环境等
	 */
	public static void main(String[] args) {

		log.info("Start RegCenter App");
		SpringApplication.run(RegApp.class, args);
		log.info("Start RegCenter App success");
	}
}