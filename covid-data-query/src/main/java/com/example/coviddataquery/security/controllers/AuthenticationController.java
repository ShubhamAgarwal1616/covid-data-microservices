package com.example.coviddataquery.security.controllers;

import com.example.coviddataquery.security.annotations.AnyAuthenticatedUser;
import com.example.coviddataquery.security.config.JwtProperties;
import com.example.coviddataquery.security.domain.AuthenticatedUser;
import com.example.coviddataquery.security.domain.AuthenticationRequest;
import com.example.coviddataquery.security.domain.AuthenticationToken;
import com.example.coviddataquery.security.domain.CovidUserDetails;
import com.example.coviddataquery.security.jwt.TokenHelper;
import com.example.coviddataquery.security.service.SecurityUtils;
import com.example.coviddataquery.users.models.Role;
import com.example.coviddataquery.users.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;

    private final JwtProperties securityConfigProperties;

    private final TokenHelper tokenHelper;

    private final SecurityUtils securityUtils;

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

    @PostMapping("${security.jwt.refresh-auth-token-path:/api/auth/refresh}")
    @AnyAuthenticatedUser
    public ResponseEntity<AuthenticationToken> refreshAuthenticationToken(HttpServletRequest request) {
        String authToken = tokenHelper.getToken(request);
        String refreshedToken = tokenHelper.refreshToken(authToken);
        return ResponseEntity.ok(
                new AuthenticationToken(
                        refreshedToken,
                        securityConfigProperties.getExpiresIn()
                )
        );
    }

    @GetMapping("${security.jwt.auth-me-path:/api/auth/me}")
    @AnyAuthenticatedUser
    public ResponseEntity<AuthenticatedUser> me() {
        User loginUser = securityUtils.loginUser();
        Set<String> roles = loginUser.getRoles().stream().map(Role::name).collect(Collectors.toSet());
        AuthenticatedUser authenticatedUser = new AuthenticatedUser(loginUser.getUsername(), loginUser.getEmail(), roles);
        return ResponseEntity.ok(authenticatedUser);
    }
}
