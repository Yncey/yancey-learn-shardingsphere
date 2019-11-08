package com.yancey.learn.core.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author jianhong.li Data: 15-8-18 Time: 下午5:07
 * @version $Id$
 */
@WebListener
public class PostSpringInitListener implements ServletContextListener {

    /**
     * 日志输出
     */
    private static final Logger logger = LoggerFactory.getLogger(PostSpringInitListener.class);

    /**
     * * Notification that the web application initialization
     * * process is starting.
     * * All ServletContextListeners are notified of context
     * * initialization before any filter or servlet in the web
     * * application is initialized.
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            logger.info("******PostSpringInitListener（contextInitialized）post Context Initialized handle start******");

            /**
             //权重计算因子初始化.
             OpContainer opContainer = SpringContextUtil.getApplicationContext().getBean(OpContainer.class);
             opContainer.initComponent();
             //计算 top 值算子初始化
             CalculatorContainer calculatorContainer = SpringContextUtil.getApplicationContext().getBean(CalculatorContainer.class);
             calculatorContainer.initComponent();
             // 月规则管理器初始化
             MonthRuleManager monthRuleManager = SpringContextUtil.getApplicationContext().getBean(MonthRuleManager.class);
             monthRuleManager.initComponent();
             **/

            logger.info("******PostSpringInitListener（contextInitialized）post Context Initialized handle end******");
        } catch (Exception e) {
            logger.error("******PostSpringInitListener（contextInitialized）初始化组件失败******", e);
        }
    }

    /**
     * * Notification that the servlet context is about to be shut down.
     * * All servlets and filters have been destroy()ed before any
     * * ServletContextListeners are notified of context
     * * destruction.
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("******PostSpringInitListener（contextDestroyed）post Context Destroyed handle start******");

        logger.info("******PostSpringInitListener（contextDestroyed）post Context Destroyed handle end******");
    }
}
