package com.xiaomi.servletstudy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by zhanghu on 2015/8/2.
 */
//��һ�� Web ��������Ӧһ�� HTTP ����ʱ����Ӧͨ������һ��״̬�С�һЩ��Ӧ��ͷ��һ�����к��ĵ���
    //http://www.runoob.com/servlet/servlet-server-response.html
public class Refresh extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(req, resp);
        // ����ˢ���Զ�����ʱ��Ϊ 5 ��
        response.setIntHeader("Refresh", 5);

        // ������Ӧ��������
        response.setContentType("text/html");

        // Get current time
        Calendar calendar = new GregorianCalendar();
        String am_pm;
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        if(calendar.get(Calendar.AM_PM) == 0)
            am_pm = "AM";
        else
            am_pm = "PM";

        String CT = hour+":"+ minute +":"+ second +" "+ am_pm;

        PrintWriter out = response.getWriter();
        String title = "flush Header setting";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p>current time is ��" + CT + "</p>\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req,resp);
    }
}
