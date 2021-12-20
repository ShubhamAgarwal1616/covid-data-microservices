package com.example.coviddataquery.users.controllers;

import com.example.coviddataquery.users.converters.UserConverter;
import com.example.coviddataquery.users.models.Role;
import com.example.coviddataquery.users.models.User;
import com.example.coviddataquery.users.requests.CreateUserRequest;
import com.example.coviddataquery.users.responses.UserResponse;
import com.example.coviddataquery.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final UserConverter userConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody CreateUserRequest createUserRequest) {
        User user = new User();
        user.setUsername(createUserRequest.getUsername());
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());
        user.setRoles(Set.of(Role.ADMIN));
        userService.createUser(user);
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.getAllUsers()
                .stream()
                .map(userConverter::convert)
                .collect(toList());
    }
}
