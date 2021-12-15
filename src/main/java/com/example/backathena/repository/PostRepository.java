package com.example.backathena.repository;

import com.example.backathena.entity.Book;
import com.example.backathena.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> getPostByBookId(Long id);
    Optional<Post> findById(Long id);
}
