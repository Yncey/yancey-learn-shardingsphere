package com.yancey.learn.service;

import com.yancey.learn.model.UserInfo;

public interface UserInfoService {

    UserInfo selectByPrimaryKey(Long id);

    int insert(UserInfo record);
}
