package com.project.manager.service;

import com.project.manager.domain.User;
import com.project.manager.dto.UserCreationRequest;

public interface UserService {

    User getByEmail(String email);

    User register(UserCreationRequest creationRequest);
}
