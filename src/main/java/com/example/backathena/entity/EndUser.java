package com.example.backathena.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class EndUser {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String userName;
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(
            name="bookshelf",
            joinColumns = @JoinColumn(name= "end_user_id"),
            inverseJoinColumns = @JoinColumn(name ="book_id")
    )
    private Set<Book> bookshelfBooks = new HashSet<>();
    private String role;


    public EndUser(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public EndUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getBookshelfBooks() {
        return bookshelfBooks;
    }

    public void setBookshelfBooks(Set<Book> bookshelfBooks) {
        this.bookshelfBooks = bookshelfBooks;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addBook(Book book) {
        bookshelfBooks.add(book);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
