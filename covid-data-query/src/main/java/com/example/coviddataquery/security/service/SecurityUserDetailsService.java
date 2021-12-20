package com.example.coviddataquery.security.service;

import com.example.coviddataquery.security.domain.CovidUserDetails;
import com.example.coviddataquery.users.models.User;
import com.example.coviddataquery.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findUserByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("No user found with email " + email);
        }
        return new CovidUserDetails(optionalUser.get());
    }
}