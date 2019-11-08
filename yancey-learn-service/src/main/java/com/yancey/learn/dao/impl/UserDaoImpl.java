package com.yancey.learn.dao.impl;

import com.yancey.learn.dao.UserDao;
import com.yancey.learn.dao.mapper.UserMapper;
import com.yancey.learn.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    /**
     * 保存
     */
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @Override
    public User get(Long id) {
        return userMapper.get(id);
    }

    /**
     * 查询列表
     *
     * @param user
     * @return
     */
    @Override
    public List<User> getParam(User user) {
        return userMapper.getParam(user);
    }

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        return userMapper.update(user);
    }
}
