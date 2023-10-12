package com.salprojects.springbootoauth.config;


import com.salprojects.springbootoauth.service.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class DefaultSecurityConfig {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    // We are binding our own customer authorization method to the main method.
    @Autowired
    public void bindAuthenticationProvider(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);
    }
}
