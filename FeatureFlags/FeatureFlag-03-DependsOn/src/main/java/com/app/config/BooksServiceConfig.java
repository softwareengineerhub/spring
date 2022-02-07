package com.app.config;

import com.app.service.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class BooksServiceConfig {

    @Bean
    @ConditionalOnProperty(name = "feature-flags.is-new-books-service-enabled", havingValue = "false", matchIfMissing = true)
    public BooksService booksDefaultService(){
        return new BooksDefaultService();
    }

    @Bean
    @ConditionalOnProperty(name = "feature-flags.is-new-books-service-enabled", havingValue = "true")
    @DependsOn(value={"A", "B"})
    public BooksService booksNewService(){
        return new BooksNewService();
    }

    @Bean
    public A A(){
        return new A();
    }

    @Bean
    public B B(){
        return new B();
    }

}
