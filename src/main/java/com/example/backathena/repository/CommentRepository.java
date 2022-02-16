package com.example.backathena.repository;

import com.example.backathena.entity.Book;
import com.example.backathena.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getCommentsByForumPostId(Long id);
    List<Comment> findAllByUserId(Long id);
}
