package com.xiaomi.servletstudy;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by zhanghu on 2015/8/2.
 */
public class SiteHitCounter implements Filter {
    private int hitCount;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        hitCount = 0;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        hitCount++;

        System.out.println("��վ�ܵ������" + hitCount);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // ��һ���ǿ�ѡ�ģ����������Ҫ�������԰� hitCount ��ֵд�뵽���ݿ�
    }
}
