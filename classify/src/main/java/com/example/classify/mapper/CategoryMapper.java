package com.example.classify.mapper;

import com.example.classify.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface CategoryMapper {
    int deleteCategory(String categoryId);

    int insert(Category record);

    int logicDeleteCategory(String categoryId);

    ArrayList<Category> selectCategorys(String userId);

    void updateCategory(Category category);
}