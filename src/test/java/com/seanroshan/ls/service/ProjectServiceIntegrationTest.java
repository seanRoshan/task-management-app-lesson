package com.seanroshan.ls.service;

import com.seanroshan.ls.persistence.model.Project;
import com.seanroshan.ls.spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


@SpringJUnitConfig(classes = TestConfig.class)
@SpringBootTest
public class ProjectServiceIntegrationTest {

    @Autowired
    private IProjectService projectService;

    @Test
    public void whenSavingProject_thenOK() {
        Project savedProject = projectService.save(new Project("NEW PROJECT", LocalDate.now()));
        assertThat(savedProject, is(notNullValue()));
    }

}
