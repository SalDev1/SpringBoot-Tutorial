package com.salman.springbootdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// currency-service.url =
// currency-service.username =
// currency-service.key =
@ConfigurationProperties(prefix = "currency-service")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyServiceConfiguration {
    private String url;
    private String username;
    private String key;
}
