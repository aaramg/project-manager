package com.project.manager.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @SequenceGenerator(name = "project_generator", sequenceName = "project_sequence")
    @GeneratedValue(generator = "project_generator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
    private Set<Task> tasks;

    public Project() {
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

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(final Set<Task> tasks) {
        this.tasks = tasks;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof Project)) return false;

        final Project project = (Project) o;

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
