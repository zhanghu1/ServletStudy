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
* 遇到的问题即解决方法：
* 出现HTTP Status 405 - HTTP method GET is not supported by this URL 原因是：
1、继承自Httpservlet的Servlet没有重写对于请求和响应的处理方法：doGet或doPost等方法，
默认调用父类的doGet或doPost等方法。
2、父类HttpServlet的doGet或doPost等方法覆盖了你写的到doGet或doPost等方法。
不管是1或2，父类HttpServlet的doGet或doPost等方法默认实现是返回状态码是405的Http错误表示
对于指定资源请求方法不被允许。
解决方法：
1、子类重写doGet或doPost等方法。
2、在你扩张的Servlet中重写doGet或doPost等方法来处理请求和响应时，
不要调用父类的doGet或doPost等方法即去掉supper.doGet(request,response)
和super.doPost(request,response);
* */
public class HelloWorld extends HttpServlet {
    private String message = null;

    @Override
    public void init() throws ServletException {
//        super.init();

        message = "Hello World";
    }

    //会执行到这里的原因是，客户端会默认发出get请求
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
