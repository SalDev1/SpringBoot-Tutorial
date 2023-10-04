package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.print.Doc;

@Configuration
@ComponentScan(basePackages = "org.example")
public class BeanConfig {
    // Define a Bean Myself in the config
//    @Bean
//    public Doctor doctor() {
//        return new Doctor();
//    }
}
