package com.seanroshan.ls.persistence.repository.impl;

import com.seanroshan.ls.persistence.model.Project;
import com.seanroshan.ls.persistence.repository.IProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProjectRepositoryImpl implements IProjectRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectRepositoryImpl.class);
    List<Project> projects = new ArrayList<>();
    @Value("${project.prefix}")
    private String prefix;
    @Value("${project.suffix}")
    private String suffix;

    public ProjectRepositoryImpl() {
        super();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        updateInternalId(project);
        if (existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }
        return project;
    }

    @Override
    public void updateInternalId(Project project) {
        LOGGER.info("Prepending Prefix " + prefix);
        LOGGER.info("Appending Suffix " + suffix);

        project.setInternalId(prefix + "_" + project.getId() + "_" + suffix);

        LOGGER.info("Generated internal id " + project.getInternalId());
    }


}
