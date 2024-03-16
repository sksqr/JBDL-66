package com.example.L15SpringSecuritydemo.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Requestfilter extends HttpFilter {

    private static Logger LOGGER = LoggerFactory.getLogger(Requestfilter.class);

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("Executing Request filter ");
        MDC.put("X-Request-Id",request.getHeader("X-Request-Id"));
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MDC.put("username", userDetails.getUsername());

        filterChain.doFilter(request,response);
        MDC.clear();
        //
    }
}
