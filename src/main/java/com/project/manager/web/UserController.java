package com.project.manager.web;

import com.project.manager.domain.User;
import com.project.manager.dto.TaskDto;
import com.project.manager.dto.UserCreationRequest;
import com.project.manager.dto.UserDto;
import com.project.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/get")
    public UserDto getUser(@Valid @NotBlank @RequestParam("email") final String email) {
        final User user = userService.getByEmail(email);
        final UserDto userDto = convertToUserDto(user);
        return userDto;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserDto> register(@Valid @NotNull @RequestBody final UserCreationRequest creationRequest) {
        final User user = userService.register(creationRequest);
        return ResponseEntity.ok(convertToUserDto(user));
    }

    private UserDto convertToUserDto(final User user) {
        final UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setRoleType(user.getRoleType());
        final Set<TaskDto> taskDtoList = user.getTasks().stream()
                .map(task -> {
                    final TaskDto taskDto = new TaskDto();
                    taskDto.setId(task.getId());
                    taskDto.setName(task.getName());
                    taskDto.setDescription(task.getDescription());
                    return taskDto;
                }).collect(Collectors.toSet());
        userDto.setTasks(taskDtoList);
        return userDto;
    }


}
