package com.seanroshan.persistence.repository.impl;

import com.seanroshan.persistence.repository.IProjectRepository;
import com.seanroshan.persistence.model.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectRepositoryImpl implements IProjectRepository {

    List<Project> projects = new ArrayList<>();

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        if (existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }
        return null;
    }
}
