package com.yancey.learn.dao;

import com.yancey.learn.model.UserInfo;

public interface UserInfoDao {

    UserInfo selectByPrimaryKey(Long id);

    int insert(UserInfo record);
}
