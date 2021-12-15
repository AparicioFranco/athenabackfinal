package com.example.backathena.controller;

import com.example.backathena.entity.Post;
import com.example.backathena.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public void createPost(@RequestBody Post post){
        postService.createPost(post);
    }

    @GetMapping("/{id}")
    public List<Post> getPostsByBook(@PathVariable Long id){
        return postService.getPostsByBook(id);
    }

    @GetMapping("/particular/{id}")
    public Post getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @GetMapping("book/{id}")
    public Long getBookIdByPostId(@PathVariable Long id){
        return postService.getPostById(id).getBookId();
    }


}
