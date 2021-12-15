package com.example.backathena.service;

import com.example.backathena.entity.Book;
import com.example.backathena.entity.Category;
import com.example.backathena.repository.BookRepository;
import com.example.backathena.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.getCategoryById(id);
    }

    public Category getCategoryByName(String category){
        return categoryRepository.getCategoryByName(category);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
