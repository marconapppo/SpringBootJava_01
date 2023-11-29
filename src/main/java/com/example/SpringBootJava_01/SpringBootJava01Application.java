package com.example.SpringBootJava_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
//@EnableSpringDataWebSupport
public class SpringBootJava01Application
{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJava01Application.class, args);
	}

}
