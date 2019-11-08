package com.yancey.learn.dao.impl;

import com.yancey.learn.dao.UserInfoDao;
import com.yancey.learn.dao.mapper.UserInfoMapper;
import com.yancey.learn.model.UserInfo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 用户信息dao实现
 *
 * @author yaxuany
 * @date 2019/10/14 下午 4:44
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectByPrimaryKey(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }
}
