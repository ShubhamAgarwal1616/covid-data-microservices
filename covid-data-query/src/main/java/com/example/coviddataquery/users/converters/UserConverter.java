package com.example.coviddataquery.users.converters;

import com.example.coviddataquery.users.models.Role;
import com.example.coviddataquery.users.models.User;
import com.example.coviddataquery.users.responses.UserResponse;

import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toSet;

@Component
public class UserConverter {

    public UserResponse convert(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles().stream().map(Role::toString).collect(toSet()))
                .build();
    }
}
