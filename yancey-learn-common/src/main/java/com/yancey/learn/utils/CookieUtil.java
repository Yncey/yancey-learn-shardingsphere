package com.yancey.learn.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * Cookie工具类
 *
 * @author yaxuany
 * @date 2018/9/4 上午10:49
 */
public final class CookieUtil {

    /**
     * 日志输出
     */
    private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);

    /**
     * 默认cookie生存期
     */
    static final int COOKIE_MAX_AGE = 24 * 60 * 60;

    /**
     * 添加新的Cookie
     *
     * @param name
     * @param value
     * @param response
     */
    public static void setCookie(final String name,
                                 final String value,
                                 final int maxAge,
                                 HttpServletResponse response) {
        try {
            final Cookie cookie = new Cookie(name, value);
            cookie.setPath("/");
            // 设置生存期，当设置为负值时，则为浏览器进程Cookie(内存中保存)，关闭浏览器就失效。
            cookie.setMaxAge(maxAge > 0 ? maxAge : COOKIE_MAX_AGE);
            response.addCookie(cookie);
        } catch (final RuntimeException e) {
            String errorInfo = name + "_" + value + "_" + maxAge + e.getMessage();
            logger.error(errorInfo, e);
        }
    }

    /**
     * 获取Cookie值
     *
     * @param name
     * @param request
     * @return
     */
    public static String getCookieValue(final String name, final HttpServletRequest request) {
        String value = StringUtils.EMPTY;
        try {
            final Cookie[] cookies = request.getCookies();
            if (null != cookies) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equalsIgnoreCase(name)) {
                        value = cookies[i].getValue();
                    }
                }
            }
        } catch (final RuntimeException e) {
            String errorInfo = name + "_" + e.getMessage();
            logger.error(errorInfo, e);
        }
        return value;
    }

    /**
     * 删除cookie中对应数值
     *
     * @param name
     * @param request
     * @param response
     */
    public static void deleteCookie(final String name,
                                    final HttpServletRequest request,
                                    final HttpServletResponse response) {
        try {
            final Cookie[] cookies = request.getCookies();
            if (null != cookies) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equalsIgnoreCase(name)) {
                        cookies[i].setValue(null);
                        cookies[i].setPath("/");
                        // 设置为0为立即删除该Cookie
                        cookies[i].setMaxAge(0);
                        response.addCookie(cookies[i]);
                    }
                }
            }
        } catch (final RuntimeException e) {
            String errorInfo = name + "_" + e.getMessage();
            logger.error(errorInfo, e);
        }
    }

    /**
     * 删除cookie中对应数值
     *
     * @param name
     * @param request
     * @param response
     */
    public static void deleteCookie(final String name,
                                    final String domain,
                                    final HttpServletRequest request,
                                    final HttpServletResponse response) {
        try {
            final Cookie[] cookies = request.getCookies();
            if (null != cookies) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equalsIgnoreCase(name)) {
                        cookies[i].setValue(null);
                        cookies[i].setPath("/");
                        cookies[i].setDomain(domain);
                        // 设置为0为立即删除该Cookie
                        cookies[i].setMaxAge(0);
                        response.addCookie(cookies[i]);
                    }
                }
            }
        } catch (final RuntimeException e) {
            String errorInfo = name + "_" + e.getMessage();
            logger.error(errorInfo, e);
        }
    }

    /**
     * 增加规定cookie中的数值
     *
     * @param name
     * @param value
     * @param request
     * @param response
     */
    public static void addNewCookieValue(final String name,
                                         final BigDecimal value,
                                         final HttpServletRequest request,
                                         final HttpServletResponse response) {
        try {
            final Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equalsIgnoreCase(name)) {
                    cookies[i].setValue(new BigDecimal(cookies[i].getValue().trim()).add(value).toString());
                    response.addCookie(cookies[i]);
                }
            }
        } catch (final RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 减去规定cookie中的数值
     *
     * @param name
     * @param value
     * @param request
     * @param response
     */
    public static void subCookieValue(final String name,
                                      final BigDecimal value,
                                      final HttpServletRequest request,
                                      final HttpServletResponse response) {
        try {
            final Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equalsIgnoreCase(name)) {
                    cookies[i].setValue(new BigDecimal(cookies[i].getValue()).subtract(value).toString());
                    response.addCookie(cookies[i]);
                }
            }
        } catch (final RuntimeException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * JS COOKIE JAVA解码
     *
     * @param src
     * @return
     * @todo
     * @author kgj
     * @update 2016年6月20日 上午10:50:07
     */
    public static String unescape(final String src) {
        final StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < src.length()) {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                } else {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }

    /**
     * 私有构造方法
     */
    private CookieUtil() {

    }
}
