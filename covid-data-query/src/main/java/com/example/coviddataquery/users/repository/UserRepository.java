package com.example.coviddataquery.users.repository;

import java.util.Optional;
import java.util.UUID;


import com.example.coviddataquery.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

}
