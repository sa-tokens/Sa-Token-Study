package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class DemoController {

    @GetMapping("/a")
    public String getA(HttpServletRequest request, HttpServletResponse response) {
        // 进行其他操作
        return (String)request.getParameter("name");
    }

    @GetMapping("/b")
    public String getB() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        // 进行其他操作
        return (String)request.getParameter("name");
    }

    // getA() 方法和 getB() 方法在功能上等价

}
