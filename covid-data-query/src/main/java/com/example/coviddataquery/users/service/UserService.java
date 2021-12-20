package com.example.coviddataquery.users.service;

import java.util.List;
import java.util.Optional;

import com.example.coviddataquery.users.models.User;
import com.example.coviddataquery.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        String encodedPassword = encodePasswordIfNotBlank(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private String encodePasswordIfNotBlank(String passwordChange) {
        return isBlank(passwordChange) ? passwordChange : passwordEncoder.encode(passwordChange);
    }
}
