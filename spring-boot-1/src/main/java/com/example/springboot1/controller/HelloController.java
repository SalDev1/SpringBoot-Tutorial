package com.example.springboot1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @Component // Now this component is in the spring radar.
// @Controller // We are creating a simple RESTFUL API's over here.

@RestController // Specifically for REST API.
// Whatever I will be doing in this class , all of it will be rest endpoints.
public class HelloController {

    // Whenever I have an endpoint , I want this method to be executed every time.

    // When we hit this endpoint or path , the below defined string is executed.
    // @RequestMapping(value = "/", method = RequestMethod.GET)

    // Rather than using Request Mapping , as we want to apply GET Method over this
    // method , we use this.

    // GET --> GetMapping , POST --> PostMapping , DELETE --> DeleteMapping.
    @GetMapping("/")
    public String helloWorld() {
        return "Welcome to Salman Uddin ! aaaaa";
    }
}

/*
 * Another way of running the application is using the command prompt :
 * mvn spring-boot:run
 */