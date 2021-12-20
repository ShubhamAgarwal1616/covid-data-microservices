package com.example.coviddataquery.security.domain;

import com.example.coviddataquery.users.models.Role;
import com.example.coviddataquery.users.models.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Delegate;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CovidUserDetails implements org.springframework.security.core.userdetails.UserDetails {

    @Getter
    @EqualsAndHashCode.Include
    private final User user;

    @Delegate(types = org.springframework.security.core.userdetails.UserDetails.class)
    private final org.springframework.security.core.userdetails.UserDetails userDetails;

    public CovidUserDetails(User user) {
        this.user = user;
        this.userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles().stream().map(Role::toString).toArray(String[]::new))
                .disabled(false)
                .build();
    }

}
