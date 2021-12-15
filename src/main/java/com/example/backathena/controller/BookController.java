package com.example.backathena.controller;

import com.example.backathena.entity.Author;
import com.example.backathena.entity.Book;
import com.example.backathena.entity.BookUser;
import com.example.backathena.service.AuthorService;
import com.example.backathena.service.BookService;
import com.example.backathena.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/book")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final BookUserService bookUserService;


    @Autowired
    public BookController(BookService bookService, AuthorService authorService, BookUserService bookUserService){
        this.bookService = bookService;
        this.authorService = authorService;
        this.bookUserService = bookUserService;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }


    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        Optional<Book> bookOptional = bookService.getBookById(id);
        return bookOptional.orElseGet(Book::new);
    }

    @GetMapping("/pages/{userId}/{bookId}")
    public Long getPages(@PathVariable Long userId, @PathVariable Long bookId){
        Optional<BookUser> bookUser = bookUserService.pages(bookId,userId);
        if (bookUser.isPresent()){
            return bookUser.get().getPageNumber();
        }else{
            BookUser bookUser1 = new BookUser(userId,bookId, 1L);
            bookUserService.save(bookUser1);
            return 1L;
        }
    }

    @PutMapping("/pages/{userId}/{bookId}/{pages}")
    public void refreshPages(@PathVariable Long userId, @PathVariable Long bookId, @PathVariable Long pages){
        Optional<BookUser> bookUser = bookUserService.pages(bookId,userId);
        if (bookUser.isPresent()){
            BookUser bookUser1 = bookUser.get();
            bookUser1.setPageNumber(pages);
            bookUserService.save(bookUser1);
        }
    }

    @GetMapping("/home/{category}")
    public List<Book> getFiveBooksFromCategory(@PathVariable String category){
        return bookService.getFiveBooksFromCategory(category);
    }

    @GetMapping("/search/{querySearch}")
    public List<Book> getBooksQuery(@PathVariable String querySearch){
        return bookService.getBooksByName(querySearch);
    }

    @GetMapping("/category/{id}")
    public List<Book> getBooksByCategory(@PathVariable Long id){
        return bookService.getBooksByCategory(id);
    }

    @GetMapping("/author/{id}")
    public List<Book> getBooksByAuthor(@PathVariable Long id){
        return bookService.getBooksByAuthor(id);
    }

    @PostMapping Book createBook(@RequestBody Book book){
        return bookService.save(book);
    }

}
