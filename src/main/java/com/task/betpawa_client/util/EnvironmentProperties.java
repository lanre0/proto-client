package com.task.betpawa_client.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "serverprop")
@Configuration("environmentProperties")
public class EnvironmentProperties {
	 private String port;
	 private String serverlocation;

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

		public String getServerlocation() {
			return serverlocation;
		}

		public void setServerlocation(String serverlocation) {
			this.serverlocation = serverlocation;
		}
		
		
}
