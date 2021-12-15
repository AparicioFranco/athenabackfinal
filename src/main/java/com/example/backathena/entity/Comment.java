package com.example.backathena.entity;


import javax.persistence.*;

@Entity
@Table
public class Comment {


    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_sequence"
    )
    private Long id;
    private Long forumPostId;
    private Long userId;
    private String username;
    private String description;

    public Comment(Long forumPostId, Long userId, String username, String description) {
        this.forumPostId = forumPostId;
        this.userId = userId;
        this.username = username;
        this.description = description;
    }

    public Comment(Long forumPostId, Long userId, String description) {
        this.forumPostId = forumPostId;
        this.userId = userId;
        this.description = description;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getForumPostId() {
        return forumPostId;
    }

    public void setForumPostId(Long forumPostId) {
        this.forumPostId = forumPostId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
