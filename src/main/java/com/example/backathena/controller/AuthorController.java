package com.example.backathena.controller;

import com.example.backathena.entity.Author;
import com.example.backathena.entity.Book;
import com.example.backathena.service.AuthorService;
import com.example.backathena.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @PostMapping
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }

    @GetMapping("/{id}")
    public Author getAthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

}
