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
//�ͻ��ˣ����������HTTP�����кܶ����Ϣ�����ǿ������÷���ȡ����Щ��Ϣ
public class DisplayHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(req, resp);
        //�������������ǳ�����UTF-8���룬���������GB2312���룬��˻��������
        //Ŀ����Ϊ�˿������������Ϊ���������������UTF-8���н��룻
        response.setContentType("text/html; charset=UTF-8");
        //��仰����˼��Ϊ�˽�response�����е�������UTF-8������������
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String title = "HTTP Header ����ʵ��";
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
                "<th>Header ����</th><th>Header ֵ</th>\n"+
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
