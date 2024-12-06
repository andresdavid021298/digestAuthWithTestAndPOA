package com.adac.projectExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ProjectExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectExampleApplication.class, args);
	}

}
