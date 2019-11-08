package com.yancey.learn.core.filter;

import com.yancey.learn.core.WrappedHttpServletRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 一次性读取流改为可重复读取过滤器
 *
 * @author yaxuany
 * @date 2019/9/18 14:06
 */
@WebFilter(filterName = "repeatReadFilter", urlPatterns = "/*")
public class RepeatReadFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            request = new WrappedHttpServletRequest((HttpServletRequest) request);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
