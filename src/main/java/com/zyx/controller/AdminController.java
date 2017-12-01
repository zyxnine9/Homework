package com.zyx.controller;

import com.zyx.exception.BRexception;
import com.zyx.model.Book;
import com.zyx.model.Reader;
import com.zyx.service.AdminService;
import com.zyx.service.Bookservice;
import com.zyx.service.Libraryservice;
import com.zyx.service.Readerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.security.RunAs;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    Bookservice bookservice;
    @Autowired
    Readerservice readerservice;
    @Autowired
    Libraryservice libraryservice;
    @Autowired
    AdminService adminService;


    @RequestMapping("/admin")
    public void adminMain(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Reader admin = (Reader) request.getSession().getAttribute("reader");
        if(admin.getAuthority()==1){
            request.getRequestDispatcher("/WEB-INF/pages/admin/main.jsp")
                    .forward(request,response);
        }else {
            request.setAttribute("error","不是管理员账号");
            request.getRequestDispatcher("/WEB-INF/pages/reader/main.jsp")
                    .forward(request,response);
        }
    }

    /*
    管理员获取图书列表
     */
    @RequestMapping(value = "/admin/books",method = RequestMethod.GET)
    public void findByName(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name=req.getParameter("bookName");
        //把查询信息暂存到session中
        req.setAttribute("bookName",name);
        req.setAttribute("books",bookservice.getByName(name));
        req.getRequestDispatcher("/WEB-INF/pages/admin/books.jsp").forward(req,resp);
    }


    //    图书详情
    @RequestMapping(value = "/admin/detail/{id}",method = RequestMethod.GET)
    public String  showdetail(@PathVariable("id") String  id, ModelMap modelMap){
        Book book=bookservice.getById(id);
        modelMap.addAttribute(book);
        return "book/detail";
    }

    //删除图书
    @RequestMapping(value = "/admin/books/delete/{id}",method = RequestMethod.GET)
    public void deleteBook(@PathVariable("id")String  id,ModelMap modelMap,
                             HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int i =adminService.deleteBook(id);
            if (i==1){
                modelMap.addAttribute("result","删除图书成功，请回到书籍列表刷新");
                HttpSession session = request.getSession();
                String name = (String) session.getAttribute("bookName");
                List<Book> books = bookservice.getByName(name);
                modelMap.addAttribute("books",books);
//                return "/admin/books";
                request.getRequestDispatcher("/WEB-INF/pages/admin/books.jsp").forward(request
                        ,response);
            }
            else {
                modelMap.addAttribute("result", "删除图书失败");
                request.getRequestDispatcher("/WEB-INF/pages/admin/books.jsp").forward(request
                        ,response);
            }
        }catch (BRexception e){
            modelMap.addAttribute("result","删除图书失败"+e.getMessage());
            request.getRequestDispatcher("/WEB-INF/pages/admin/books.jsp").forward(request
                    ,response);
        }catch (RuntimeException e1){
            modelMap.addAttribute("result","删除图书失败"+e1.getMessage());
            request.getRequestDispatcher("/WEB-INF/pages/admin/books.jsp").forward(request
                    ,response);
        }
    }

    /*
    跳转到更新图书页面
     */
    @RequestMapping(value = "/admin/books/update/{id}",method = RequestMethod.GET)
    public String  updateBook(@PathVariable("id")String id,ModelMap modelMap){
        Book book=bookservice.getById(id);
        modelMap.addAttribute("book",book);
        return "/admin/update_book";
    }
    /*
    更新图书操作
     */
    @RequestMapping(value = "/admin/books/doUpdate",method = RequestMethod.POST)
    public String doUpdateBook(@ModelAttribute("book")Book book){
        bookservice.updateBook(book);
        return "redirect:/admin/books";
    }


    @RequestMapping("/returnMainPage")
    public String  returnMain(){
        return "reader/main";
    }
}
