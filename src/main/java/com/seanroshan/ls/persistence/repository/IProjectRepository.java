package com.seanroshan.ls.persistence.repository;

import com.seanroshan.ls.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);

    void updateInternalId(Project project);
}
