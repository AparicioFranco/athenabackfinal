package com.example.backathena.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Book {


    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String title;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Category mainCategory;
    @JsonIgnore
    @ManyToMany(mappedBy = "bookshelfBooks")
    private Set<EndUser> usersBookshelf = new HashSet<>();
    private String description;
    private Long pageCount;
    private String image;
    private String pdfLink;

    public Book(String title, Author author, Category mainCategory, String description, Long pageCount, String image, String pdfLink) {
        this.title = title;
        this.author = author;
        this.mainCategory = mainCategory;
        this.description = description;
        this.pageCount = pageCount;
        this.image = image;
        this.pdfLink = pdfLink;
    }



    public Book(String title, Author author, String description, Long pageCount, Category mainCategoryId) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.pageCount = pageCount;
        this.mainCategory = mainCategoryId;
    }

    public Book(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }

    public Set<EndUser> getUsersBookshelf() {
        return usersBookshelf;
    }

    public void setUsersBookshelf(Set<EndUser> usersBookshelf) {
        this.usersBookshelf = usersBookshelf;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author authorId) {
        this.author = authorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public Category getMainCategoryId() {
        return mainCategory;
    }

    public void setMainCategoryId(Category mainCategoryId) {
        this.mainCategory = mainCategoryId;
    }

    public Category getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(Category mainCategory) {
        this.mainCategory = mainCategory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
