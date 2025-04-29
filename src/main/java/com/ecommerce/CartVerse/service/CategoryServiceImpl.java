package com.ecommerce.CartVerse.service;

import com.ecommerce.CartVerse.model.Category;
import com.ecommerce.CartVerse.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {
    //private long nextId = 1L;

   // private List<Category> categories= new ArrayList<>();
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {

        //category.setCategoryId(nextId ++);
        categoryRepository.save(category);

    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        categoryRepository.delete(category);
        return "Category Deleted for ID: "+categoryId;
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {


        Category savedCategory=categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
        category.setCategoryId(categoryId);
        savedCategory=categoryRepository.save(category);
        return savedCategory;



    }


}
