package com.example.backathena.repository;

import com.example.backathena.entity.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EndUserRepository extends JpaRepository<EndUser, Long> {
    Optional<EndUser> findById(Long id);
    Optional<EndUser> findByEmail(String email);
}
