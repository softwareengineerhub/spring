package com.app.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "my.task")
@Component
public class MyTaskProperties {

    private String mailSubject;

}
