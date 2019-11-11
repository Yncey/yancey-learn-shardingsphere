package com.yancey.learn.controller;

import com.alibaba.fastjson.JSON;
import com.yancey.learn.dao.UserDao;
import com.yancey.learn.model.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 用户控制层
 *
 * @author yaxuany
 * @date 2019/10/14 下午 5:36
 */
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/user/save")
    @ResponseBody
    public String save() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("test" + i);
            user.setCityId(i % 2 == 0 ? 3 : 4);
            user.setCreateTime(new Date());
            user.setSex(i % 2 == 0 ? 1 : 2);
            user.setPhone("11111111" + i);
            user.setEmail("xxxxx");
            if (i % 2 == 0) {
                user.setCreateTime(DateTime.now().minusMonths(1).toDate());
            } else {
                user.setCreateTime(DateTime.now().toDate());
            }
            user.setPassword("eeeeeeeeeeee");
            userDao.insert(user);
        }

        return "success";
    }

    @RequestMapping("/user/get/{id}")
    @ResponseBody
    public User get(@PathVariable Long id) {
        User user = userDao.get(id);
        System.out.println(JSON.toJSONString(user));
        return user;
    }

    @RequestMapping("/user/getParam")
    @ResponseBody
    public List<User> getParam(@RequestBody User user) {
        List<User> param = userDao.getParam(user);
        System.out.println(param.size());
        return param;
    }

    @RequestMapping("/user/update")
    @ResponseBody
    public User get(@RequestBody User user) {
        int size = userDao.update(user);
        System.out.println(size);
        return user;
    }
}
