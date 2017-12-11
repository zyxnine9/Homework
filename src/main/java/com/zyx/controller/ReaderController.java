package com.zyx.controller;

import com.zyx.exception.BRexception;
import com.zyx.exception.NobkException;
import com.zyx.exception.SuccesException;
import com.zyx.model.Library;
import com.zyx.model.Reader;
import com.zyx.service.Bookservice;
import com.zyx.service.Libraryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    private Bookservice bookservice;
    @Autowired
    private Libraryservice libraryservice;


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
    public String doBorrow(@ModelAttribute("library")Library library,ModelMap modelMap){
        try{
            bookservice.borrowBook(library);
            return "reader/main";
        }
        catch (NobkException e1){
            modelMap.addAttribute("error", e1.getMessage());
            return "exception/defeated";
        }catch (BRexception e){
            modelMap.addAttribute("error", e.getMessage());
            return "exception/defeated";
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
    public String doReturn(@ModelAttribute("library")Library library,ModelMap modelMap){
        try{
            bookservice.returnBook(library);
            return "reader/main";
        }catch (BRexception e){
            modelMap.addAttribute("error",e.getMessage());
            return "exception/defeated";
        }catch (SuccesException e1){
            modelMap.addAttribute("error", e1.getMessage());
            return "exception/succse";
        }
    }
    /*
    转到借阅记录界面
     */
    @RequestMapping(value = "/main/record",method = RequestMethod.GET
    )
    public void toRecord(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Reader reader= (Reader) session.getAttribute("reader");
        List<Library> records=libraryservice.selectByReaderId(reader.getId());
        request.setAttribute("records",records);
        request.getRequestDispatcher("/WEB-INF/pages/reader/record.jsp")
                .forward(request,response);
    }

}
