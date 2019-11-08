package com.yancey.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring boot 启动入口
 *
 * @author yaxuany
 * @date 2019/9/18 17:21
 */
@EnableTransactionManagement(proxyTargetClass = true)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.yancey.learn.dao.mapper"}, sqlSessionFactoryRef = "sessionFactory")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class YanceyLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(YanceyLearnApplication.class, args);
    }

}
