package org.ppke.itk.registrationsystem.repository;

import org.ppke.itk.registrationsystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
