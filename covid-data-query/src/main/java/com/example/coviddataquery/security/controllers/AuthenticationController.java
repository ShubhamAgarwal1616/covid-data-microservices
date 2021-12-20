package com.example.coviddataquery.security.controllers;

import com.example.coviddataquery.security.config.JwtProperties;
import com.example.coviddataquery.security.domain.AuthenticationRequest;
import com.example.coviddataquery.security.domain.AuthenticationToken;
import com.example.coviddataquery.security.domain.CovidUserDetails;
import com.example.coviddataquery.security.jwt.TokenHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;

    private final JwtProperties securityConfigProperties;

    private final TokenHelper tokenHelper;

    @PostMapping("${security.jwt.create-auth-token-path:/api/auth/login}")
    public AuthenticationToken createAuthenticationToken(@RequestBody AuthenticationRequest credentials) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        CovidUserDetails userDetails = (CovidUserDetails) authentication.getPrincipal();
        String jws = tokenHelper.generateToken(userDetails.getUsername());
        return new AuthenticationToken(jws, securityConfigProperties.getExpiresIn());
    }
}
