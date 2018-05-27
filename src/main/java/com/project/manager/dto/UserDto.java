package com.project.manager.dto;

import com.project.manager.common.RoleType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Set;

public class UserDto {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private RoleType roleType;

    private Set<TaskDto> tasks;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(final RoleType roleType) {
        this.roleType = roleType;
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

        if (!(o instanceof UserDto)) return false;

        final UserDto user = (UserDto) o;

        return new EqualsBuilder()
                .append(id, user.id)
                .append(email, user.email)
                .append(firstName, user.firstName)
                .append(lastName, user.lastName)
                .append(roleType, user.roleType)
                .append(tasks, user.tasks)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(email)
                .append(firstName)
                .append(lastName)
                .append(roleType)
                .append(tasks)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("email", email)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("roleType", roleType)
                .append("tasks", tasks)
                .toString();
    }
}
