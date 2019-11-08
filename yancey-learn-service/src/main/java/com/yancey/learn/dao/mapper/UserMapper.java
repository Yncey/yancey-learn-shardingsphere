package com.yancey.learn.dao.mapper;

import com.yancey.learn.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

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
