package com.example.classify.ctrl;

import com.alibaba.fastjson.JSON;
import com.example.classify.entity.User;
import com.example.classify.service.UserService;
import com.example.classify.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/user")
@RestController
public class UserCtroller {

    @Autowired
    private UserService userService;

    @PostMapping("/insertUser")
    public String insertUser (@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString().replace("-",""));
        user.setName("test");
        return userService.insertUser(user);
    }

    @PostMapping("/selectUser")
    public String selectUser (@RequestBody User user){
        return JSON.toJSONString(userService.selectUser(user));
    }

}
