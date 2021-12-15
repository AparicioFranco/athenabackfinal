package com.example.backathena.entity;

/*
title
authors[0]
publishedDate ?
description
pageCount
mainCategory
imageLinks[0] => smallThumbnail
 */


import javax.persistence.*;

@Entity
@Table
public class Category {

    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private Long id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
