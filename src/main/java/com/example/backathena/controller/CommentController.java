package com.example.backathena.controller;

import com.example.backathena.entity.Book;
import com.example.backathena.entity.Comment;
import com.example.backathena.entity.Post;
import com.example.backathena.service.BookService;
import com.example.backathena.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping
    public void createComment(@RequestBody Comment comment){
        commentService.createComment(comment);
    }

    @GetMapping("/{id}")
    public List<Comment> getCommentsByPost(@PathVariable Long id){
        return commentService.getComments(id);
    }

}
