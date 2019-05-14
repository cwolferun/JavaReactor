package com.reaction.JavaReactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

//@EnableJpaRepositories
@SpringBootApplication
public class JavaReactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaReactorApplication.class, args);
	}

}
