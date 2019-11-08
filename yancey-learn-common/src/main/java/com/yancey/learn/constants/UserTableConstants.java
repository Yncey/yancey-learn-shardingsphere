package com.yancey.learn.constants;

/**
 * 用户表相关常量
 *
 * @author yaxuany
 * @date 2019/11/08 下午 4:57
 */
public class UserTableConstants {

    /**
     * 用户记录表名
     */
    public static final String USER_TABLE_LOGIC_NAME = "t_user";

    /**
     * 用户记录表物理名格式
     */
    public static final String USER_TABLE_PHYSICAL_NAME_FORMAT = "t_user_%s";

    /**
     * 用户记录表物理名正则
     */
    public static final String USER_TABLE_PHYSICAL_NAME_REGEX = "t_user_\\d{6}";

    /**
     * 用户记录表物理名月份格式
     */
    public static final String USER_TABLE_PHYSICAL_NAME_MONTH_PATTERN = "yyyyMM";

    /**
     * 用户记录表分片依据字段: 创建时间
     */
    public static final String USER_COLUMN_NAME_CREATE_TIME = "create_time";

    /**
     * 用户记录表主键
     */
    public static final String USER_COLUMN_NAME_ID = "id";

    /**
     * 主从配置名
     */
    public static final String USER_MASTER_SLAVE_RULE_NAME = "ds_ms";

    private UserTableConstants() {
    }
}
