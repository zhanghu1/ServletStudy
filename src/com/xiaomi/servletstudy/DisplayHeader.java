package com.xiaomi.servletstudy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by zhanghu on 2015/8/2.
 */
//http://www.runoob.com/servlet/servlet-client-request.html
//客户端（浏览器）的HTTP包含有很多的信息，我们可以利用方法取得这些信息
public class DisplayHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(req, resp);
        //输出乱码的问题是程序用UTF-8编码，而浏览器用GB2312解码，因此会出现乱码
        //目的是为了控制浏览器的行为，即控制浏览器用UTF-8进行解码；
        response.setContentType("text/html; charset=UTF-8");
        //这句话的意思是为了将response对象中的数据以UTF-8解码后发向浏览器
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String title = "HTTP Header 请求实例";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "<th>Header 名称</th><th>Header 值</th>\n"+
                "</tr>\n");

        Enumeration headerNames = requset.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            out.print("<tr><td>" + headerName + "</td>\n");
            String headerValue = requset.getHeader(headerName);
            out.println("<td> " + headerValue + "</td></tr>\n");
        }

        out.println("</table>\n</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req,resp);
    }
}
