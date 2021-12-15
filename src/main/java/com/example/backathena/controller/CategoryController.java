package com.example.backathena.controller;

import com.example.backathena.entity.Book;
import com.example.backathena.entity.Category;
import com.example.backathena.service.BookService;
import com.example.backathena.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }


}
