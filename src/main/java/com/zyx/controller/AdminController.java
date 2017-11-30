package com.zyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {
    @RequestMapping("/admin")
    public void adminMain(HttpServletRequest request, HttpServletResponse response){
        request.getSession().getAttribute("");
    }
    
}
