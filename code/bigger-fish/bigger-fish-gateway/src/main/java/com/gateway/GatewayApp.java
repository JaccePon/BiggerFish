package com.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * The gateway of spring cloud
 *
 * <p>
 *
 * @author 3306 2017年9月19日下午10:05:00
 *
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayApp {

	private static Logger log = LoggerFactory.getLogger(GatewayApp.class);

	public static void main(String[] args) {
		log.info("Start gateway app ");
		SpringApplication.run(GatewayApp.class, args);
		log.info("Start gateway app success ");
	}
}
