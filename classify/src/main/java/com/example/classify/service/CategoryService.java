package com.example.classify.service;

import com.example.classify.entity.Category;

import java.util.ArrayList;

public interface CategoryService {

    void insertCategory(Category category);

    ArrayList<Category> getCategorys(String userId);
}
