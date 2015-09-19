package com.xiaomi.servletstudy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhanghu on 2015/8/2.
 */
public class PageRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(req, resp);
        response.setContentType("text/html");

        String webSite = new String("http://www.csdn.net");
        //重定向的第一种方式
//        response.setStatus(response.SC_MOVED_TEMPORARILY);
//        response.setHeader("Location", site);

        //重定向的第二种方式
        response.sendRedirect(webSite);
    }
}
