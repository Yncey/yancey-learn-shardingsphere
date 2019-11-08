package com.yancey.learn.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 地址实体类
 *
 * @author yaxuany
 * @date 2019/10/14 下午 5:32
 */
@Data
public class Address implements Serializable {

    private static final long serialVersionUID = 4378439196451976329L;
    private Long id;
    private String code;
    private String name;
    private String pid;
    private Integer type;
    private Integer lit;

}
