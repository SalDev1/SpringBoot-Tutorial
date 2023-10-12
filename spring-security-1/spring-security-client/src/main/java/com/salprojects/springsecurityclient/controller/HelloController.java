package com.salprojects.springsecurityclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Salman";
    }

    @GetMapping("/api/hello")
    public String helloApi(Principal principal) {
        return "Hello" + principal.getName() + "Hello , Welcome to Daily Code Buffer !!!";
    }

    @GetMapping("/api/users")
    public String[] users(@RegisteredOAuth2AuthorizedClient("api-client-authorization-code") OAuth2AuthorizedClient client) {
        return
                this.webClient.get().
                        uri("http://127.0.0.1:8090/api/users")
                        .attributes(oauth2AuthorizedClient(client))
                        .retrieve()
                        .bodyToMono(String[].class).block();
    }
}
