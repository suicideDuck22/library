package com.levelup.library.controllers.util;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@WebFilter("/*")
public class RequestController implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Passou aqui");
        System.out.println((((HttpServletRequest) servletRequest).getHeader("Authorization")));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
