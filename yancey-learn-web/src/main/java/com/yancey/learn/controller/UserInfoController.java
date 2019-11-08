package com.yancey.learn.controller;

import com.alibaba.fastjson.JSON;
import com.yancey.learn.core.AbstractController;
import com.yancey.learn.model.UserInfo;
import com.yancey.learn.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户相关api接口
 *
 * @author yaxuany
 * @date 2019/9/18 11:30
 */
@Controller
@RequestMapping("/api/user")
public class UserInfoController extends AbstractController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 获取用户信息
     *
     * @return
     */
    @RequestMapping(value = "/info.api", method = RequestMethod.POST)
    @ResponseBody
    public String userInfo(@RequestBody Long id) {
//        logger.info("UserInfoController.userInfo 用户主键ID. {},{}", id, env);
        UserInfo userInfo = userInfoService.selectByPrimaryKey(id);
        logger.info("UserInfoController.userInfo 用户信息. {}", userInfo);
        return JSON.toJSONString(userInfo);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @RequestMapping(value = "/save.api", method = RequestMethod.POST)
    @ResponseBody
    public String insert() {
//        logger.info("UserInfoController.userInfo 用户主键ID. {},{}", id, env);
        UserInfo userInfo = new UserInfo();
        userInfo.setId(12L);
        userInfo.setAge(11);
        userInfo.setBirthday(new Date());
        userInfo.setName("哈哈");
        userInfo.setSex(1);
        userInfo.setUpdateTime(new Date());
        userInfo.setCreateTime(new Date());
        userInfoService.insert(userInfo);
        logger.info("UserInfoController.userInfo 用户信息. {}", userInfo);
        return JSON.toJSONString(userInfo);
    }
}
