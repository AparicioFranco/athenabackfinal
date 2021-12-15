package com.example.backathena.service;

import com.example.backathena.entity.Book;
import com.example.backathena.entity.Comment;
import com.example.backathena.entity.Notification;
import com.example.backathena.entity.Post;
import com.example.backathena.repository.BookRepository;
import com.example.backathena.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final NotificationService notificationService;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostService postService, NotificationService notificationService){
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.notificationService = notificationService;
    }

    public void createComment(Comment comment){
        Long postId = comment.getForumPostId();
        Post post = postService.getPostById(postId);
        Notification notification = new Notification(post.getUserId(),postId,false,post.getPostTitle());
        if (!Objects.equals(comment.getUserId(), post.getUserId())){
            notificationService.save(notification);
        }
        commentRepository.save(comment);
    }

    public List<Comment> getComments(@PathVariable Long id) {
        return commentRepository.getCommentsByForumPostId(id);
    }

}
