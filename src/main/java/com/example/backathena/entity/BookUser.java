package com.example.backathena.entity;

import javax.persistence.*;

@Entity
@Table
public class BookUser {

    @Id
    @SequenceGenerator(
            name = "bookuser_sequence",
            sequenceName = "bookuser_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bookuser_sequence"
    )
    private Long id;
    private Long userId;
    private Long bookId;
    private Long pageNumber;

    public BookUser(Long userId, Long bookId, Long pageNumber) {
        this.userId = userId;
        this.bookId = bookId;
        this.pageNumber = pageNumber;
    }

    public BookUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }
}
