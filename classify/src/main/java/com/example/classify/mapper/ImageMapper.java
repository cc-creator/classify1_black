package com.example.classify.mapper;

import com.example.classify.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface ImageMapper {
    int deleteByPrimaryKey(String imageId);

    int insert(Image record);

    int insertSelective(Image record);

    Image selectByPrimaryKey(String imageId);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);

    ArrayList<Image> selectImages(String categoryId);
}