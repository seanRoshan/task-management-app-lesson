package com.seanroshan.ls.service.impl;

import com.seanroshan.ls.persistence.model.Project;
import com.seanroshan.ls.persistence.repository.IProjectRepository;
import com.seanroshan.ls.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final IProjectRepository projectRepo;

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
