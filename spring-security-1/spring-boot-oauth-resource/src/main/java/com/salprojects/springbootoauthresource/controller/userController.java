package com.salprojects.springbootoauthresource.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @GetMapping("/api/users")
    public String[] getUser() {
        return new String[] {"Shabbir" , "Nikhil" , "Shivam"};
    }
}
