package com.project.manager.domain;

import com.google.common.collect.Lists;
import com.project.manager.common.RoleType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "`user`")
public class User implements UserDetails {
    private static final long serialVersionUID = -8632813353208855706L;

    @Id
    @SequenceGenerator(name = "user_generator", sequenceName = "user_sequence")
    @GeneratedValue(generator = "user_generator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "role_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Task> tasks;

    public User() {
    }

    public User(final String email, final String passwordHash, final String firstName, final String lastName, final RoleType roleType) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleType = roleType;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(final String passwordHash) {
        this.passwordHash = passwordHash;
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

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(final Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Lists.newArrayList(new SimpleGrantedAuthority("ROLE_" + roleType.name()));
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public String getPassword() {
        return getPasswordHash();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof User)) return false;

        final User user = (User) o;

        return new EqualsBuilder()
                .append(id, user.id)
                .append(email, user.email)
                .append(passwordHash, user.passwordHash)
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
                .append(passwordHash)
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
                .append("passwordHash", passwordHash)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("roleType", roleType)
                .append("tasks", tasks)
                .toString();
    }
}
