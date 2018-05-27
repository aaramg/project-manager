package com.project.manager.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class TaskDto {

    private Long id;

    private String name;

    private String description;

    private UserDto user;

    private ProjectDto project;

    public TaskDto() {
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(final UserDto user) {
        this.user = user;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(final ProjectDto project) {
        this.project = project;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof TaskDto)) return false;

        final TaskDto task = (TaskDto) o;

        return new EqualsBuilder()
                .append(id, task.id)
                .append(name, task.name)
                .append(description, task.description)
                .append(user, task.user)
                .append(project, task.project)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(description)
                .append(user)
                .append(project)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("description", description)
                .append("user", user)
                .append("project", project)
                .toString();
    }
}
