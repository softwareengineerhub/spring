package com.app.config;

import com.app.service.BooksDefaultService;
import com.app.service.BooksNewService;
import com.app.service.BooksService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FeatureFlags.class)
public class BooksServiceConfig {

    @Bean
    @ConditionalOnProperty(name = "feature-flags.is-new-books-service-enabled", havingValue = "false", matchIfMissing = true)
    public BooksService booksDefaultService(){
        return new BooksDefaultService();
    }

    @Bean
    @ConditionalOnProperty(name = "feature-flags.is-new-books-service-enabled", havingValue = "true")
    public BooksService booksNewService(){
        return new BooksNewService();
    }

}
