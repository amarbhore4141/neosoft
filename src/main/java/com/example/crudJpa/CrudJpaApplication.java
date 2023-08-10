package com.example.crudJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
public class CrudJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudJpaApplication.class, args);
		System.out.println("spring application started" + "");
	}

}
