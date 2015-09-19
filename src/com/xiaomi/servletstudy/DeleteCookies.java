package com.xiaomi.servletstudy;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhanghu on 2015/8/2.
 */
public class DeleteCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(req, resp);
        Cookie[] cookies = request.getCookies();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Delete Cookies Example";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");

        if (null != cookies) {
            out.println("<h2>Cookies key and value</h2>");
            for (Cookie cookie : cookies) {
                if (0 == (cookie.getName()).compareTo("first_name")) {
                    //删除一个Cookie的思想就是把它的生存时间设置为0，
                    //同时传回给客户端（浏览器）
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    out.print("the deleted cookie is : " +
                            cookie.getName() + "<br/>");
                }
                out.print("key : " + cookie.getName( ) + "，");
                out.print("value : " + cookie.getValue( )+" <br/>");
            }
        } else {
            out.println(
                    "<h2>No cookies founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req,resp);
    }
}
