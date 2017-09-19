package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * The service of spring cloud
 *
 * <p>
 *
 * @author 3306 2017年9月19日下午10:11:22
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceApp {

	private static Logger log = LoggerFactory.getLogger(ServiceApp.class);

	public static void main(String[] args) {

		log.info("Start ServerApp");

		SpringApplication.run(ServiceApp.class, args);

		log.info("Start ServerApp success");
	}

}
