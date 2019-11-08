package com.yancey.learn.model;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 *
 * @author yaxuany
 * @date 2019/10/14 下午 5:30
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -1242896736345443051L;
    private Long id;
    private String name;
    private Integer cityId;
    private Integer sex;
    private String phone;
    private String email;
    private Date createTime;
    private String password;

//    public void setSex(Boolean sex) {
//        if (sex) {
//            this.sex = 1;
//        } else {
//            this.sex = 2;
//        }
//    }
}
