package com.seanroshan.ls;

import com.seanroshan.ls.config.ProjectAnnotationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ProjectAnnotationProperties.class)
public class LsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsApplication.class, args);
    }

}
