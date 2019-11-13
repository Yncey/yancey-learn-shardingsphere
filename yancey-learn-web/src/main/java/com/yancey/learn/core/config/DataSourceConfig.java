package com.yancey.learn.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yancey.learn.shardingrule.DatePreciseShardingAlgorithm;
import com.yancey.learn.utils.ShardingUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import static com.yancey.learn.constants.UserTableConstants.*;

/**
 * 数据源配置
 *
 * @author yaxuany
 * @date 2019/11/06 上午 11:21
 */
@Configuration
public class DataSourceConfig {

    /**
     * 配置主数据源
     *
     * @return
     */
    @Bean(name = "master")
    @ConfigurationProperties(prefix = "spring.shardingsphere.datasource.master")
    public DataSource dataMaster() {
        return new DruidDataSource();
    }

    /**
     * 配置数据源slave0
     *
     * @return
     */
    @Bean(name = "slave0")
    @ConfigurationProperties(prefix = "spring.shardingsphere.datasource.slave0")
    public DataSource dataSlave0() {
        return new DruidDataSource();
    }

    /**
     * 配置数据源slave1
     *
     * @return
     */
    @Bean(name = "slave1")
    @ConfigurationProperties(prefix = "spring.shardingsphere.datasource.slave1")
    public DataSource dataSlave1() {
        return new DruidDataSource();
    }

    /**
     * sharding配置
     *
     * @return
     * @throws SQLException
     */
    @Bean
    public DataSource dataSource() throws SQLException {

        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();

        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = Maps.newHashMap();
        DataSource master = dataMaster();
        dataSourceMap.put("master", master);
        dataSourceMap.put("slave0", dataSlave0());
        dataSourceMap.put("slave1", dataSlave1());

        shardingRuleConfig.setDefaultDataSourceName("master");

        // 主从数据源配置
        Collection<String> slave = Lists.newArrayList();
        slave.add("slave0");
        slave.add("slave1");
        MasterSlaveRuleConfiguration masterSlaveRule = new MasterSlaveRuleConfiguration(USER_MASTER_SLAVE_RULE_NAME, "master", slave);
        shardingRuleConfig.getMasterSlaveRuleConfigs().add(masterSlaveRule);

        // 添加分表策略
        shardingRuleConfig.getTableRuleConfigs().add(this.getUserTableRuleConfig(master));

        // 配置其余信息
        Properties properties = new Properties();
        properties.setProperty("executor.size", "20");
        properties.setProperty("sql.show", "true");

        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, properties);
    }

    /**
     * 用户分表读取策略
     *
     * @param dataSource
     * @return
     * @throws SQLException
     */
    private TableRuleConfiguration getUserTableRuleConfig(@NonNull DataSource dataSource) throws SQLException {
        List<String> tables = ShardingUtil.getShardingTables(dataSource, USER_TABLE_PHYSICAL_NAME_REGEX);
        Assert.notEmpty(tables, "tables must not be empty.");
        String actualDataNodes = tables.stream()
                .map(table -> USER_MASTER_SLAVE_RULE_NAME + "." + table)
                .collect(Collectors.joining(","));

        TableRuleConfiguration userTableRuleConfig = new TableRuleConfiguration(USER_TABLE_LOGIC_NAME, actualDataNodes);

        // 分表保存策略
        userTableRuleConfig.setTableShardingStrategyConfig(
                new StandardShardingStrategyConfiguration(USER_COLUMN_NAME_CREATE_TIME, new DatePreciseShardingAlgorithm()));

        // 主键生成规则
        KeyGeneratorConfiguration keyGeneratorConfiguration = new KeyGeneratorConfiguration("SNOWFLAKE", USER_COLUMN_NAME_ID);

        userTableRuleConfig.setKeyGeneratorConfig(keyGeneratorConfiguration);
        return userTableRuleConfig;
    }

    /**
     * 构建sessionFactory
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sessionFactory(@NonNull DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml"));
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*Mapper.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public DataSourceTransactionManager shardTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
