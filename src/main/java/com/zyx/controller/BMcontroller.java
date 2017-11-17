package com.zyx.controller;

import com.sun.mail.imap.protocol.BODY;
import com.zyx.model.Book;
import com.zyx.service.Bookservice;
import com.zyx.service.Readerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class BMcontroller {

    @Autowired
    private Bookservice bookservice;

//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public String hello(){
//        return "hello";
//    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String toMain(){
        return "reader/main";
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

