package com.yancey.learn.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 分表工具类
 *
 * @author yaxuany
 * @date 2019/11/08 下午 5:05
 */
public final class ShardingUtil {

    private static final String QUERY_TABLE_NAME_SQL_FORMAT
            = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '%s';";

    /**
     * 获取表所有的分片名
     *
     * @param dataSource     数据源
     * @param tableNameRegex 表名正则
     * @return 表所有的分片名
     * @throws SQLException
     */
    public static List<String> getShardingTables(DataSource dataSource, String tableNameRegex) throws SQLException {
        Objects.requireNonNull(dataSource);
        Objects.requireNonNull(tableNameRegex);
        List<String> tableNames = new ArrayList<>(128);
        try (Connection connection = dataSource.getConnection()) {
            String catalog = connection.getCatalog();
            String queryTableNameSql = String.format(QUERY_TABLE_NAME_SQL_FORMAT, catalog);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryTableNameSql);
            while (resultSet.next()) {
                String tableName = resultSet.getString(1);
                if (tableName != null && tableName.matches(tableNameRegex)) {
                    tableNames.add(tableName);
                }
            }
        }
        return tableNames;
    }

    private ShardingUtil() {
    }
}
