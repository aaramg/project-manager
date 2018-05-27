package com.project.manager.service.impl;

import com.project.manager.common.RoleType;
import com.project.manager.domain.User;
import com.project.manager.dto.UserCreationRequest;
import com.project.manager.repository.UserRepository;
import com.project.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Value("${pm.user.admin.list}")
    private String[] admins;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getByEmail(final String email) {
        Assert.hasText(email, "email cannot be empty");

        final Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.orElseThrow(() -> new IllegalStateException("User is not found"));
    }

    @Override
    public User register(final UserCreationRequest creationRequest) {
        final User user = new User();
        user.setEmail(creationRequest.getEmail());
        user.setPasswordHash(BCrypt.hashpw(creationRequest.getPassword(), BCrypt.gensalt(12)));
        user.setFirstName(creationRequest.getFirstName());
        user.setLastName(creationRequest.getLastName());
        user.setRoleType(isAdmin(creationRequest.getEmail()) ? RoleType.ADMIN : RoleType.REGULAR);
        return userRepository.save(user);
    }


    private boolean isAdmin(final String email) {
        return Arrays.asList(admins).contains(email);
    }
}
