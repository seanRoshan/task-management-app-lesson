package com.seanroshan.ls.persistence.repository;

import com.seanroshan.ls.persistence.model.Project;
import com.seanroshan.ls.persistence.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProjectRepositoryIntegrationTest {

    @Autowired
    IProjectRepository projectRepository;

    @Autowired
    IProjectCustomRepository projectCustomRepository;


    @Autowired
    ITaskRepository taskRepository;


    @Test
    public void whenSavingNewProject_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        assertThat(projectCustomRepository.save(newProject), is(notNullValue()));
    }


    @Test
    public void givenProject_whenFindById_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectCustomRepository.save(newProject);

        Optional<Project> retrievedProject = projectCustomRepository.findById(newProject.getId());
        assertThat(retrievedProject.isPresent(), is(true));
        assertThat(retrievedProject.get(), is(equalTo(newProject)));
    }

    @Test
    public void givenProject_whenFindByName_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retrievedProject = projectRepository.findByName(newProject.getName());
        assertThat(retrievedProject.isPresent(), is(true));
        assertThat(retrievedProject.get(), is(equalTo(newProject)));
    }


    @Test
    public void givenProjectCreated_whenFindByDateCreatedBetween_thenSuccess() {
        Project oldProject = new Project(randomAlphabetic(6), LocalDate.now().minusYears(1));
        projectRepository.save(oldProject);

        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Project newProject2 = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject2);

        List<Project> retrievedProjects = projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertThat(retrievedProjects, hasItems(newProject, newProject2));
    }

    @Test
    public void givenProjectCreated_thenFindByTaskNameMatchesSuccess() {
        Task task1 = new Task("Low Priority Task", "Low Priority Task", LocalDate.now(), LocalDate.now());
        Task task2 = new Task("Low Priority Task", "Low Priority Task", LocalDate.now(), LocalDate.now());
        Task task3 = new Task("High Priority Task", "High Priority Task", LocalDate.now(), LocalDate.now());
        Task task4 = new Task("High Priority Task", "High Priority Task", LocalDate.now(), LocalDate.now());

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);

        List<Task> retrievedTasks = taskRepository.findByNameMatches("High");
        assertThat(retrievedTasks, contains(task3, task4));
    }

    @Test
    public void givenDataCreated_whenFindAllPaginated_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2));

        assertThat(retrievedProjects.getContent(), hasSize(2));
    }

    @Test
    public void givenDataCreated_whenFindAllSort_thenSuccess() {
        List<Project> retrievedProjects = (List<Project>) projectRepository.findAll(Sort.by(Sort.Order.asc("name")));

        List<Project> sortedProjects = new ArrayList<>(retrievedProjects);
        sortedProjects.sort(Comparator.comparing(Project::getName));

        assertEquals(sortedProjects, retrievedProjects);
    }

    @Test
    public void givenDataCreated_whenFindAllPaginatedAndSort_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Order.asc("name"))));

        assertThat(retrievedProjects.getContent(), hasSize(2));
    }

}
