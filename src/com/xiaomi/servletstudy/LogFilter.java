package com.xiaomi.servletstudy;


import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by zhanghu on 2015/8/2.
 */
//http://www.runoob.com/servlet/servlet-writing-filters.html
public class LogFilter implements Filter {
    //��ʼ����������ֻ��ִ��һ��
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //��ȡ��ʼ������
        String testParam = filterConfig.getInitParameter("test-param");
        System.out.println("Test param : " + testParam);
    }

    //ע�⣬web�������ڵ���servlet��service֮ǰ���ǻ���ù�������ʵ����Filter���౻��Ϊ��������
    //��doFilter�ķ���
    //web.xml �е� filter-mapping Ԫ�ص�˳������� Web ����Ӧ�ù������� Servlet ��˳��
    // ��Ҫ��ת��������˳����ֻ��Ҫ�� web.xml �ļ��з�ת filter-mapping Ԫ�ؼ��ɡ�
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ipAddress = servletRequest.getRemoteAddr();
        System.out.println("IP : " + ipAddress + ", Time : " + new Date().toString());

        //�����󴫻ع�����
        //����������������ԭ���ǿ����ڹ������л������������Ĺ����������ԣ���Ҫ
        //���´��ݣ����û�й������ˣ����ȥ����Ŀ����Դ����service����
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
