package com.yancey.learn.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 标准 Controller 异步处理.返回标准 API 格式.
 *
 * @author yaxuany
 * @date 2019/9/18 14:36
 */
public abstract class AbstractController {

    /**
     * 日志输出
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

}
