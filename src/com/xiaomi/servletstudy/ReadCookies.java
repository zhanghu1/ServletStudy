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
public class ReadCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(req, resp);
//        Cookie cookie = null;
        Cookie[] cookies;
        cookies = request.getCookies();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Reading Cookies Example";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");

        if (null != cookies) {
            out.println("<h2>find Cookies key and value</h2>");
            for (Cookie cookie : cookies) {
                out.print("key £º" + cookie.getName( ) + "£¬");
                out.print("value £º" + cookie.getValue( )+" <br/>");
            }
        } else {
            out.println(
                    "<h2>do not find Cookies</h2>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}
