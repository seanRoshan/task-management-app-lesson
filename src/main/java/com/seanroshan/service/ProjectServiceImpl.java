package com.seanroshan.service;

import com.seanroshan.persistence.model.Project;
import com.seanroshan.persistence.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectRepository projectRepo;


    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }
}
