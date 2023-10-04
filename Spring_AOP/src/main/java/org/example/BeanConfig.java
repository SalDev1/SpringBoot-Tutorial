package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/*
*  Whatever components I create , this file
* will scan all the components in the base
* package available and use it according to our needs.
* */

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy
public class BeanConfig {
}
