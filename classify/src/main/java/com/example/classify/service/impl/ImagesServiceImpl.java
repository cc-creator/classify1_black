package com.example.classify.service.impl;

import com.example.classify.entity.Image;
import com.example.classify.mapper.ImageMapper;
import com.example.classify.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 郭聪聪
 * @project classify
 * @package com.example.classify.service.impl
 * @file TestServiceImpl 创建时间:2020-3-30
 * @title
 * @description
 * @copyright Copyright (c) 2019 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
@Service
public class ImagesServiceImpl implements ImagesService {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public String insertImages(Image image) {
        try {
            imageMapper.insert(image);
            return "SUCCESS";
        }catch (Exception e){
            System.out.println(e);
            return "FALSE";
        }
    }

    @Override
    public ArrayList<Image> selectImages(String categoryId) {

        return imageMapper.selectImages(categoryId);
    }

    @Override
    public void logDelImages(String categoryId) {
        imageMapper.logicDeleteImages(categoryId);
    }
}
