package com.web.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * WebSocket配置
 *
 * <p>
 *
 * @author 3306 2017年9月26日下午9:49:05
 *
 */
@Configuration
public class WebScoketConfig {

	/**
	 * 建立ServerEndpointExporter实例
	 * 
	 * @return {@link ServerEndpointExporter}
	 */
	@Bean
	public ServerEndpointExporter buildServerEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
