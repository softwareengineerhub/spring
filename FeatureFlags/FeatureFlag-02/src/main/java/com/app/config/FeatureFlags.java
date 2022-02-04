package com.app.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "feature-flags")
public class FeatureFlags {
    private Boolean isNewBooksServiceEnabled = false;
    private Boolean isNewPapersServiceEnabled = false;

}
