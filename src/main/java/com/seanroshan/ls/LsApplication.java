package com.seanroshan.ls;

import com.seanroshan.ls.config.ProjectAnnotationProperties;
import com.seanroshan.ls.persistence.model.Project;
import com.seanroshan.ls.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
@EnableConfigurationProperties(ProjectAnnotationProperties.class)
public class LsApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(LsApplication.class);

    final IProjectService projectService;

    public LsApplication(IProjectService projectService) {
        this.projectService = projectService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LsApplication.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        Project newProject = new Project("Sean", LocalDate.now());
        Project savedProject = projectService.save(newProject);
        LOGGER.info("Saved project: " + savedProject);
    }

}
