package com.example.backathena.repository;

import com.example.backathena.entity.Author;
import com.example.backathena.entity.Book;
import com.example.backathena.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findAllByTitleIsContainingIgnoreCase(String string);
    List<Book> findAllByAuthor(Author author);
    Optional<Book> findById(Long id);
    List<Book> findAllByMainCategory(Category category);

}
