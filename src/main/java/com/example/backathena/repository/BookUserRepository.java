package com.example.backathena.repository;

import com.example.backathena.entity.Author;
import com.example.backathena.entity.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookUserRepository extends JpaRepository<BookUser, Long> {
    Optional<BookUser> findByBookIdAndUserId(Long bookId, Long UserId);
}
