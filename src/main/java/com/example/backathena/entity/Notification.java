package com.example.backathena.entity;


import javax.persistence.*;

@Entity
@Table
public class Notification {


    @Id
    @SequenceGenerator(
            name = "notification_sequence",
            sequenceName = "notification_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_sequence"
    )
    private Long id;
    private Long userId;
    private Long postId;


    private String postTitle;
    private boolean read;

    public Notification(Long userId, Long postId, boolean read, String postTitle) {
        this.userId = userId;
        this.postId = postId;
        this.read = read;
        this.postTitle = postTitle;
    }

    public Notification(){
    }



    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
