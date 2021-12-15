package com.example.backathena.service;

import com.example.backathena.entity.Author;
import com.example.backathena.entity.Book;
import com.example.backathena.entity.Category;
import com.example.backathena.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @Autowired
    public BookService(BookRepository bookRepository, CategoryService categoryService, AuthorService authorService){
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBooksByName(String querySearch) {
        return bookRepository.findAllByTitleIsContainingIgnoreCase(querySearch);
    }

    public List<Book> getBooksByAuthor(Long id){
        Author author = authorService.getAuthorById(id);
        return bookRepository.findAllByAuthor(author);
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public List<Book> getBooksByCategory(Long id) {
        Category category = categoryService.getCategoryById(id);
        return bookRepository.findAllByMainCategory(category);
    }

    public List<Book> getFiveBooksFromCategory(String category) {
        Category category1 = categoryService.getCategoryByName(category);
        return getBooksByCategory(category1.getId()).subList(0,5);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
