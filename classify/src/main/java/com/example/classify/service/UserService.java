package com.example.classify.service;

import com.example.classify.entity.User;

/**
 * @author 郭聪聪
 * @project classify
 * @package com.example.classify.service
 * @file TestService 创建时间:2020-3-30
 * @title
 * @description
 * @copyright Copyright (c) 2019 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public interface UserService {

    String insertUser(User user);

    User selectUser(User user);
}
