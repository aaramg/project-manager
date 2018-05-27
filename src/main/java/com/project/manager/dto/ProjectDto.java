package com.project.manager.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

public class ProjectDto {

    private Long id;

    private String name;

    private String description;

    private Set<TaskDto> tasks;

    public ProjectDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Set<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(final Set<TaskDto> tasks) {
        this.tasks = tasks;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof ProjectDto)) return false;

        final ProjectDto project = (ProjectDto) o;

        return new EqualsBuilder()
                .append(id, project.id)
                .append(name, project.name)
                .append(description, project.description)
                .append(tasks, project.tasks)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(description)
                .append(tasks)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("description", description)
                .append("tasks", tasks)
                .toString();
    }
}
