package com.lt.spring.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LabsApplication implements ApplicationRunner {

	@Autowired
	ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(LabsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		MessageGenerator mg = ctx.getBean(MessageGenerator.class);
		System.out.printf("%s from Spring Boot\n", mg.getMessage());
		System.out.println("---");
		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.printf("BEAN %s%n", name);
		}
	}
}
