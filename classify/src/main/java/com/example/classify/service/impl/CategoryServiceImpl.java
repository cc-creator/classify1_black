package com.example.classify.service.impl;

import com.example.classify.entity.Category;
import com.example.classify.mapper.CategoryMapper;
import com.example.classify.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 郭聪聪
 * @project classify
 * @package com.example.classify.service.impl
 * @file CategoryServiceImpl 创建时间:2020-4-2
 * @title
 * @description
 * @copyright Copyright (c) 2019 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void insertCategory(Category category) {

         categoryMapper.insert(category);
    }

    @Override
    public ArrayList<Category> getCategorys(String userId) {

        return categoryMapper.selectCategorys(userId);
    }

    @Override
    public void logDelCategory(String categoryId) {
        categoryMapper.logicDeleteCategory(categoryId);
    }
}
