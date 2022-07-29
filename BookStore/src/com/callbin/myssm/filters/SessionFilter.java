package com.callbin.myssm.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/13 21:19
 */

@WebFilter(
        urlPatterns = {"*.do", "*.html"},
        initParams = {
                @WebInitParam(
                        name = "bai",
                        value = "/BookStore/page.do?operate=page&page=user/login," +
                                "/BookStore/user.do?null," +
                                "/BookStore/page.do?operate=page&page=user/regist"
                )
        }
)
public class SessionFilter implements Filter {
    List<String> baiList = null;

    @Override
    public void init(FilterConfig config) throws ServletException {
        String str = config.getInitParameter("bai");
        String[] split = str.split(",");
        baiList = Arrays.asList(split);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        String str = requestURI + "?" + queryString;

//        System.out.println(request.getRequestURI());
//        System.out.println(request.getQueryString());

        if (baiList.contains(str)) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("page.do?operate=page&page=user/login");
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
