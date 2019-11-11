package com.yancey.learn.shardingrule;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import static com.yancey.learn.constants.UserTableConstants.USER_TABLE_PHYSICAL_NAME_FORMAT;
import static com.yancey.learn.constants.UserTableConstants.USER_TABLE_PHYSICAL_NAME_MONTH_PATTERN;

/**
 * 根据日期分片
 *
 * @author yaxuany
 * @date 2019/11/04 下午 5:40
 */
public class DatePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Date> {

    /**
     * 日志输出
     */
    private final Logger logger = LoggerFactory.getLogger(DatePreciseShardingAlgorithm.class);

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> shardingValue) {
        Date createTime = shardingValue.getValue();
        String dataMonth = DateTime.now().toString(USER_TABLE_PHYSICAL_NAME_MONTH_PATTERN, Locale.CHINA);
        try {
            dataMonth = LocalDate.fromDateFields(createTime).toString(USER_TABLE_PHYSICAL_NAME_MONTH_PATTERN, Locale.CHINA);
        } catch (Exception e) {
            logger.error("解析创建时间异常，分表失败，进入默认表");
        }
        return String.format(USER_TABLE_PHYSICAL_NAME_FORMAT, dataMonth);
    }
}
