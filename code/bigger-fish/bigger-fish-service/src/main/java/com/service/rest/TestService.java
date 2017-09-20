package com.service.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestService {

	@Value("${server.port}")
	private String serverPort;

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(String hello) {
		return "This is irs-service.hello(" + serverPort + "): " + hello;
	}

}
