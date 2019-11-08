package com.yancey.learn.service.impl;

import com.yancey.learn.dao.UserInfoDao;
import com.yancey.learn.model.UserInfo;
import com.yancey.learn.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息相关service实现
 *
 * @author yaxuany
 * @date 2019/10/14 下午 4:43
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo selectByPrimaryKey(Long id) {
        return userInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfo record) {
        return userInfoDao.insert(record);
    }
}
