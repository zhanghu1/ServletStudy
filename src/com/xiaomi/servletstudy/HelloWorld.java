package com.xiaomi.servletstudy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhanghu on 2015/8/1.
 */
/*
* ���������⼴���������
* ����HTTP Status 405 - HTTP method GET is not supported by this URL ԭ���ǣ�
1���̳���Httpservlet��Servletû����д�����������Ӧ�Ĵ�������doGet��doPost�ȷ�����
Ĭ�ϵ��ø����doGet��doPost�ȷ�����
2������HttpServlet��doGet��doPost�ȷ�����������д�ĵ�doGet��doPost�ȷ�����
������1��2������HttpServlet��doGet��doPost�ȷ���Ĭ��ʵ���Ƿ���״̬����405��Http�����ʾ
����ָ����Դ���󷽷���������
���������
1��������дdoGet��doPost�ȷ�����
2���������ŵ�Servlet����дdoGet��doPost�ȷ����������������Ӧʱ��
��Ҫ���ø����doGet��doPost�ȷ�����ȥ��supper.doGet(request,response)
��super.doPost(request,response);
* */
public class HelloWorld extends HttpServlet {
    private String message = null;

    @Override
    public void init() throws ServletException {
//        super.init();

        message = "Hello World";
    }

    //��ִ�е������ԭ���ǣ��ͻ��˻�Ĭ�Ϸ���get����
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(request, response);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "<h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
