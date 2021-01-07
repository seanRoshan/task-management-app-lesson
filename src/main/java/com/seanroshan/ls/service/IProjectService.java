package com.seanroshan.ls.service;

import com.seanroshan.ls.persistence.model.Project;

import java.util.Optional;

public interface IProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
