package com.seanroshan.ls.persistence.repository.impl;

import com.seanroshan.ls.persistence.model.Project;
import com.seanroshan.ls.persistence.repository.IProjectCustomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class ProjectCustomRepositoryImpl implements IProjectCustomRepository {


    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public Optional<Project> findById(Long id) {
        Project entity = entityManager.find(Project.class, id);
        return Optional.ofNullable(entity);
    }

    @Transactional
    @Override
    public Project save(Project project) {
        entityManager.persist(project);
        return project;
    }

}
