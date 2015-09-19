package com.xiaomi.servletstudy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhanghu on 2015/8/2.
 */
public class PageHitCounter extends HttpServlet {
    private int hitCount;

    @Override
    public void init() throws ServletException {
//        super.init();
        hitCount = 0;
    }

    @Override
    protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(req, resp);
        // ������Ӧ��������
        response.setContentType("text/html");
        // �÷����� Servlet �����ʱִ��
        // ���� hitCount
        hitCount++;
        PrintWriter out = response.getWriter();
        String title = "hit count";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">" + hitCount + "</h2>\n" +
                "</body></html>");
    }

    @Override
    public void destroy() {
//        super.destroy();
        // ��һ���ǿ�ѡ�ģ����������Ҫ�������԰� hitCount ��ֵд�뵽���ݿ�
    }
}
