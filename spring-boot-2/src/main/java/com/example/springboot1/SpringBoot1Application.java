package com.example.springboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
		// System.out.println("Hello there , this is springBoot");
	}
}

// The port is running 8080 , the default tomcat container port --> auto
// configuration.

// If I want to change the default port number , I must add the configuration in
// appplications.properties files.

// After Configuring H2 , go to the url/h2-console.

// I am switching database from h2 --> MySQL.