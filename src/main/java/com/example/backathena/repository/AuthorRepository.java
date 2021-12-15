package com.example.backathena.repository;

import com.example.backathena.entity.Author;
import com.example.backathena.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author getAuthorById(Long id);
    Author getAuthorByAuthorName(String name);
}
