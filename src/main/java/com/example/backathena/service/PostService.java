package com.example.backathena.service;

import com.example.backathena.entity.Book;
import com.example.backathena.entity.Post;
import com.example.backathena.repository.BookRepository;
import com.example.backathena.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post createPost(Post post){
        return postRepository.save(post);
    }

    public List<Post> getPostsByBook(Long id) {
        return postRepository.getPostByBookId(id);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).get();
    }

    public String getPostTitleById(Long id){
        return postRepository.findById(id).get().getPostTitle();
    }
}
