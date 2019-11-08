package com.yancey.learn.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 *
 * @author yaxuany
 * @date 2019-09-17
 */
@Data
public class UserInfo implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别(0-未知的性别;1-男性;2-女性;5-女性改（变）为男性;6-男性改（变）为女性;9-未说明的性别)
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}