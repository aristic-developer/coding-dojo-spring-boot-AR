package com.assignment.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "weather", ignoreUnknownFields = false)
@Data
public class ApplicationProperties {
	
	public final API api = new API();
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Data
	public static class API {
		private String url;
		private String key;
	}
	
	
	

}
