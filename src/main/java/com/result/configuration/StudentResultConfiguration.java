package com.result.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class StudentResultConfiguration {
	@Bean
public RestTemplate rest() {
		
		return new RestTemplate();
	}
	
	

}
