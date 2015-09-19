package com.xiaomi.servletstudy;


import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by zhanghu on 2015/8/2.
 */
//http://www.runoob.com/servlet/servlet-writing-filters.html
public class LogFilter implements Filter {
    //初始化操作，这只是执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取初始化参数
        String testParam = filterConfig.getInitParameter("test-param");
        System.out.println("Test param : " + testParam);
    }

    //注意，web服务器在调用servlet的service之前总是会调用过滤器（实现了Filter的类被称为过滤器）
    //的doFilter的方法
    //web.xml 中的 filter-mapping 元素的顺序决定了 Web 容器应用过滤器到 Servlet 的顺序。
    // 若要反转过滤器的顺序，您只需要在 web.xml 文件中反转 filter-mapping 元素即可。
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ipAddress = servletRequest.getRemoteAddr();
        System.out.println("IP : " + ipAddress + ", Time : " + new Date().toString());

        //把请求传回过滤链
        //这里调用这个方法的原因是可能在过滤链中还存在着其他的过滤器，所以，需要
        //向下传递，如果没有过滤器了，则才去调用目标资源，即service方法
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
