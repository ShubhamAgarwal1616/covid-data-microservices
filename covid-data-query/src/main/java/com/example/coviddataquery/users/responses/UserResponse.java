package com.example.coviddataquery.users.responses;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserResponse {
    private String username;

    private String email;

    private Set<String> roles;
}
