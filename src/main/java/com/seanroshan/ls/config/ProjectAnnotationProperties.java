package com.seanroshan.ls.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "project")
public class ProjectAnnotationProperties {


    /**
     * Prefix for the project id
     */
    String prefix;

    /**
     * Suffix for the project id
     */
    String suffix;

}
