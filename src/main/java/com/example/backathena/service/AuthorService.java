package com.example.backathena.service;

import com.example.backathena.entity.Author;
import com.example.backathena.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id){
        return authorRepository.getAuthorById(id);
    }

    public Author getAuthorByName(String name){
        return authorRepository.getAuthorByAuthorName(name);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
