package com.salprojects.springsecurityclient.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


// Add the spring security dependency into the pom.xml file.
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private static final String[] WHITE_LIST_URLS = {
       "/hello", "/register" , "/verifyRegistration*" , "/resendVerifyToken*","/resetPassword*", "/savePassword*","/changePassword",
    };
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    // This thing down below help to configure
    // some API urls whitelisted to the user.

   // http://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html#security-matchers
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // We want whiteList/customized URLs to be authorized by the spring security.
        // 	We specified multiple URL patterns that any user can access.

        // Disable the csrf to remove unauthorized acesss from the POST method.
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(WHITE_LIST_URLS).permitAll()
                        .requestMatchers("/api/**").authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/oauth2/authorization/api-client-oidc"))
                .oauth2Client(Customizer.withDefaults());

        return http.build();
    }
}
