package com.jbhunt.copy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class SpringBootReadXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReadXmlApplication.class, args);
	}

}
