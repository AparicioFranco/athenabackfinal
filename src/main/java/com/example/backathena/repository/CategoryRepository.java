package com.example.backathena.repository;

import com.example.backathena.entity.Author;
import com.example.backathena.entity.Book;
import com.example.backathena.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
}
