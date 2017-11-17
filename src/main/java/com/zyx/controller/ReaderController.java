package com.zyx.controller;

import com.zyx.exception.BRexception;
import com.zyx.exception.NobkException;
import com.zyx.model.Library;
import com.zyx.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    private Bookservice bookservice;


    //    查找图书
    @RequestMapping(value = "/main/search",method = RequestMethod.POST)
    public void findByName(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name=req.getParameter("name");
        req.setAttribute("name",name);
        req.setAttribute("books",bookservice.getByName(name));
        req.getRequestDispatcher("/WEB-INF/pages/book/books.jsp").forward(req,resp);
    }

    /*
    转到借书页面
     */
    @RequestMapping("/main/borrow")
    public String toBorrow(){
        return "reader/borrow";
    }

//    借书
    @RequestMapping(value = "/borrow/borrowbook",method = RequestMethod.POST)
    public String doBorrow(@ModelAttribute("library")Library library){
        try{
            bookservice.borrowBook(library);
            return "reader/main";
        }
        catch (NobkException e1){
            return "exception/nobook";
        }catch (BRexception e){
            return "exception/noreader";
        }
    }

    /*
    转到还书界面
     */
    @RequestMapping("/main/return")
    public String toReturn(){
        return "reader/return";
    }

    //还书
    @RequestMapping(value = "/return/returnbook",method = RequestMethod.POST)
    public String doReturn(@ModelAttribute("library")Library library){
        try{
            bookservice.returnBook(library);
            return "reader/main";
        }catch (BRexception e){
            return "exception/noborrow";
        }
    }
    /*
    转到借阅记录界面
     */
    @RequestMapping("/main/record")
    public String toRecord(){
        return "reader/record";
    }

}
