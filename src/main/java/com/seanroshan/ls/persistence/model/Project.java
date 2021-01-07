package com.seanroshan.ls.persistence.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Project {

    private Long id;
    private String name;
    private LocalDate dateCreated;

    private String internalId;

    public Project() {
    }

    public Project(Long id, String name, LocalDate dateCreated) {
        this.id = generateId(id);
        this.name = name;
        this.dateCreated = dateCreated;
        this.internalId = "";
    }

    public Project(String name, LocalDate dateCreated) {
        this.id = generateId(null);
        this.name = name;
        this.dateCreated = dateCreated;
    }

    @SuppressWarnings("CopyConstructorMissesField")
    public Project(Project project) {
        this(project.getId(), project.getName(), project.getDateCreated());
    }

    private Long generateId(Long id) {
        long newId = Objects.isNull(id) ? new Random().nextLong() : id;
        return Math.abs(newId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id.equals(project.id) && Objects.equals(name, project.name) && Objects.equals(dateCreated, project.dateCreated) && Objects.equals(internalId, project.internalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateCreated, internalId);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", internalId='" + internalId + '\'' +
                '}';
    }
}
