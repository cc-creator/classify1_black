package com.example.classify.mapper;

import com.example.classify.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface ImageMapper {

    int deleteImages(String imageId);

    int insert(Image record);

    ArrayList<Image> selectImages(String categoryId);

    void logicDeleteImages(String categoryId);
}