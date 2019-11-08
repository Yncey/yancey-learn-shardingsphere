package com.yancey.learn.dao;

import com.yancey.learn.model.User;

import java.util.List;

public interface UserDao {

    /**
     * 保存
     */
    int insert(User user);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    User get(Long id);

    /**
     * 查询列表
     *
     * @param user
     * @return
     */
    List<User> getParam(User user);

    /**
     * 更新
     *
     * @param user
     * @return
     */
    int update(User user);
}
