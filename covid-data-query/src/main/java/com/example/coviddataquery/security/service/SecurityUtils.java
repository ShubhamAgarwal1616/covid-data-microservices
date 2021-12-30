package com.example.coviddataquery.security.service;

import com.example.coviddataquery.security.domain.CovidUserDetails;
import com.example.coviddataquery.users.models.User;
import com.example.coviddataquery.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUtils {

    private final UserService userService;

    public User loginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal() == null) {
            return null;
        }
        if (authentication.getPrincipal() instanceof CovidUserDetails) {
            CovidUserDetails securityUser = (CovidUserDetails) authentication.getPrincipal();
            return securityUser.getUser();
        } else if (authentication instanceof UsernamePasswordAuthenticationToken) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userService.findUserByEmail(userDetails.getUsername()).orElse(null);
        }
        return null;
    }
}
