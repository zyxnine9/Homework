package com.zyx.controller;

import com.sun.mail.imap.protocol.BODY;
import com.zyx.model.Book;
import com.zyx.model.Reader;
import com.zyx.service.Bookservice;
import com.zyx.service.Readerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BMcontroller {

    @Autowired
    private Bookservice bookservice;
    @Autowired
    private Readerservice readerservice;

//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public String hello(){
//        return "hello";
//    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String toMain(){
//        return "/reader/main";
        return "hello";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void   Login(HttpServletRequest request, HttpServletResponse response,
                      @ModelAttribute("reader")Reader reader)
            throws ServletException, IOException {
        Reader validation =readerservice.getUserByIdAndKey(reader.getId(),reader.getPassword());
        if (validation == null){
            request.setAttribute("error","登陆失败");
            request.getRequestDispatcher("/WEB-INF/pages/hello.jsp")
                    .forward(request,response);
        }
        else {
            HttpSession session=request.getSession();
            session.setMaxInactiveInterval(2*60*60);
            session.setAttribute("reader",validation);
            request.getRequestDispatcher("/WEB-INF/pages/reader/main.jsp")
                    .forward(request,response);

        }
    }

    //展示所有图书
    @RequestMapping(value = "/book/books",method = RequestMethod.GET)
    public String showbooks(ModelMap modelMap){
        List<Book> books=bookservice.getAll();
        modelMap.addAttribute("books",books);
        return "/book/books";
    }

//    图书详情
    @RequestMapping(value = "/book/detail/{id}",method = RequestMethod.GET)
    public String  showdetail(@PathVariable("id") String  id, ModelMap modelMap){
        Book book=bookservice.getById(id);
        modelMap.addAttribute(book);
        return "book/detail";
    }


}

