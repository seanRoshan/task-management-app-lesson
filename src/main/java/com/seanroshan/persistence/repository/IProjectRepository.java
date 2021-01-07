package com.seanroshan.persistence.repository;

import com.seanroshan.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
