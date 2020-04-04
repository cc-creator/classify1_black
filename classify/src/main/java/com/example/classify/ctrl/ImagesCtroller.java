package com.example.classify.ctrl;

import com.alibaba.fastjson.JSON;
import com.example.classify.entity.Category;
import com.example.classify.entity.Image;
import com.example.classify.service.CategoryService;
import com.example.classify.service.ImagesService;
import com.example.classify.utils.FTPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 郭聪聪
 * @project classify
 * @package com.example.classify.ctrl
 * @file TestCtroller 创建时间:2020-3-30
 * @title
 * @description
 * @copyright Copyright (c) 2019 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
@RequestMapping("/images")
@RestController
public class ImagesCtroller {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImagesService imagesService;

    @PostMapping("/uploadImages")
    public String uploadImages(HttpServletRequest request){

        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        List<MultipartFile> images = params.getFiles("images");
        /*上传图片到nginx服务器，取得url*/
        String[] urls = FTPUtil.uploadFile(images);
        String userId = request.getParameter("userId");
        String ctitle = request.getParameter("ctitle");
        String remark = request.getParameter("remark");
        String dateTime = request.getParameter("dateTime");
        Category category = new Category();
        String categoryId = UUID.randomUUID().toString().replace("-", "");
        category.setCategoryId(categoryId);
        category.setUserId(userId);
        category.setCtitle(ctitle);
        category.setRemark(remark);
        category.setDatetime(dateTime);
        category.setCover(urls[0]);
        categoryService.insertCategory(category);
        String[] dateTimes = request.getParameterValues("dateTimes");
        String[] label1s = request.getParameterValues("label1s");
        String[] label2s = request.getParameterValues("label2s");
        for(int i=0;i<urls.length;i++){
            Image temp_image = new Image();
            temp_image.setUrl(urls[i]);
            temp_image.setImageId(UUID.randomUUID().toString().replace("-", ""));
            temp_image.setCategoryId(categoryId);
            temp_image.setDatetime(dateTimes[i]);
            temp_image.setLabel1(label1s[i]);
            temp_image.setLabel2(label2s[i]);
            try {
                imagesService.insertImages(temp_image);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return JSON.toJSONString("SUCCESS");
    }

    @PostMapping("/getImages")
    public String getImages(@RequestBody Map<String,String> map) {
        return JSON.toJSONString(imagesService.selectImages(map.get("categoryId")));
    }

}
