package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
	info = @Info(
		title = "Employee Service Rest API",
		description = "Employee Service Rest APIs Documentation",
		version = "v1.0"
	)
)
@SpringBootApplication
@EnableFeignClients
public class EmployeeApplication {

	//restTemplate
	// @Bean
	// public RestTemplate restTemplate(){
	// 	return new RestTemplate();
	// }

	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
