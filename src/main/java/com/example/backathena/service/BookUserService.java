package com.example.backathena.service;

import com.example.backathena.entity.Author;
import com.example.backathena.entity.BookUser;
import com.example.backathena.repository.AuthorRepository;
import com.example.backathena.repository.BookUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookUserService {

    private final BookUserRepository bookUserRepository;

    @Autowired
    public BookUserService(BookUserRepository bookUserRepository){
        this.bookUserRepository = bookUserRepository;
    }

    public BookUser save(BookUser bookUser){
        return bookUserRepository.save(bookUser);
    }

    public Optional<BookUser> pages(Long bookId, Long userId){
        return bookUserRepository.findByBookIdAndUserId(bookId,userId);
    }
}
