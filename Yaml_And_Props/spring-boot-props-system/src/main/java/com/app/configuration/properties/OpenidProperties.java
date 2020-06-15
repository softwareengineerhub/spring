package com.app.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "my.openid")
@Component
public class OpenidProperties {
    private String uiClientId;
    private String uiClientId2;

    public String getUiClientId() {
        return uiClientId;
    }

    public void setUiClientId(String uiClientId) {
        this.uiClientId = uiClientId;
    }
}
