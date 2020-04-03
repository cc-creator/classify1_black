package com.example.classify.ctrl;

import com.alibaba.fastjson.JSON;
import com.example.classify.entity.Category;
import com.example.classify.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 郭聪聪
 * @project classify
 * @package com.example.classify.ctrl
 * @file CategoryCtroller 创建时间:2020-4-2
 * @title
 * @description
 * @copyright Copyright (c) 2019 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */

@RequestMapping("/category")
@RestController
public class CategoryCtroller {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/getCategorys")
    public String getCategorys(@RequestBody Map<String,String> map) {
        return JSON.toJSONString(categoryService.getCategorys(map.get("userId")));
    }
}
