package com.seanroshan.service.impl;

import com.seanroshan.persistence.model.Project;
import com.seanroshan.persistence.repository.IProjectRepository;
import com.seanroshan.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final IProjectRepository projectRepo;

    @Autowired
    public ProjectServiceImpl(IProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }
}
