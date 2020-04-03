package com.example.classify.service.impl;

import com.example.classify.entity.User;
import com.example.classify.mapper.UserMapper;
import com.example.classify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String insertUser(User user) {
        try{
            userMapper.insert(user);
            System.out.println("成功");
            return "SUCCESS";
        }catch (Exception e){
            System.out.println(e);
            return "FALSE";
        }
    }

    @Override
    public User selectUser(User user) {
        return userMapper.selectUser(user);
    }
}
