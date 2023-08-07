package com.neosoft.demopoc;

import com.neosoft.demopoc.service.HeaderDataService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.springframework.boot.SpringApplication;




@EnableConfigurationProperties(value = HeaderDataService.class)
@SpringBootApplication
public class DemoPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPocApplication.class, args);
		System.out.println("application started" );
	}
@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
}
}
