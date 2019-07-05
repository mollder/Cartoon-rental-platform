package com.krafton.cartoonrantalplatform.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@Bean
	public RestTemplate restTemplate() {
		return restTemplateBuilder.build();
	}
}
