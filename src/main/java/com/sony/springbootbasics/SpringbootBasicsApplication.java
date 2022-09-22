package com.sony.springbootbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // --> implies @Configuration, @ComponentScan
public class SpringbootBasicsApplication {

	public static void main(String[] args) {
		// This line creates a spring container, loads all the beans from
		// SpringbootBasicsApplication class
		// and starts a web server (Apache Tomcat) at port 8080
		SpringApplication.run(SpringbootBasicsApplication.class, args);
	}

}
