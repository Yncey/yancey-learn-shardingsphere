package com.yancey.learn;

import org.joda.time.LocalDate;

import java.util.Date;
import java.util.Locale;

import static com.yancey.learn.constants.UserTableConstants.USER_TABLE_PHYSICAL_NAME_MONTH_PATTERN;

/**
 * 测试类
 *
 * @author yaxuany
 * @date 2019/11/08 下午 7:27
 */
public class T {

    public static void main(String[] args) {
        String s = LocalDate.fromDateFields(new Date()).toString(USER_TABLE_PHYSICAL_NAME_MONTH_PATTERN, Locale.CHINA);
        System.out.println(s);
    }
}
