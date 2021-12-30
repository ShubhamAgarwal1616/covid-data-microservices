package com.example.coviddataquery.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUser {
    private String username;
    private String email;
    private Set<String> roles = new HashSet<>();
}
