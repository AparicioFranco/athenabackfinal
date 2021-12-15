package com.example.backathena.controller;

import com.example.backathena.entity.Book;
import com.example.backathena.entity.EndUser;
import com.example.backathena.entity.User;
import com.example.backathena.service.BookService;
import com.example.backathena.service.EndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class EndUserController {

    private final EndUserService endUserService;
    private final BookService bookService;

    @Autowired
    public EndUserController(EndUserService endUserService, BookService bookService){
        this.endUserService = endUserService;
        this.bookService = bookService;
    }

    @PostMapping
    public void createUser(@RequestBody EndUser user){
        endUserService.save(user);
    }

    @GetMapping("{userId}")
    public EndUser getUser(@PathVariable Long userId){
        return endUserService.getEndUserById(userId).get();
    }

    @DeleteMapping("/book/{bookId}/{userId}")
    EndUser delteBookInBookshelf(
            @PathVariable Long bookId,
            @PathVariable Long userId
    ){
        Book book = bookService.getBookById(bookId).get();
        EndUser endUser = endUserService.getEndUserById(userId).get();
        endUser.getBookshelfBooks().remove(book);
        return endUserService.save(endUser);
    }

    @PutMapping("/book/{bookId}/{userId}")
    EndUser addBookToBookshelf(
            @PathVariable Long bookId,
            @PathVariable Long userId
    ){
        Book book = bookService.getBookById(bookId).get();
        EndUser endUser = endUserService.getEndUserById(userId).get();
        endUser.addBook(book);
        return endUserService.save(endUser);
    }

    @GetMapping("/{bookId}/{userId}")
    boolean isBookInBookshelf(
            @PathVariable Long bookId,
            @PathVariable Long userId
    ){
        Book book = bookService.getBookById(bookId).get();
        EndUser endUser = endUserService.getEndUserById(userId).get();
        return endUser.getBookshelfBooks().contains(book);
    }

    @PostMapping("/login")
    public EndUser login(@RequestBody EndUser user){
        return endUserService.login(user);
    }

}
