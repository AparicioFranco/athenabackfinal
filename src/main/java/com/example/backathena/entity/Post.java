package com.example.backathena.entity;


import javax.persistence.*;

@Entity
@Table
public class Post {

    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    private Long id;
    private Long bookId;
    private Long userId;
    private String postTitle;
    private String postDescription;
    private String username;


    public Post(Long bookId, Long userId, String postTitle, String postDescription) {
        this.bookId = bookId;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postDescription = postDescription;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", postTitle='" + postTitle + '\'' +
                ", postDescription='" + postDescription + '\'' +
                '}';
    }
}
