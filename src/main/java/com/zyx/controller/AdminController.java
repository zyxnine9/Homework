package com.zyx.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.zyx.exception.BRexception;
import com.zyx.exception.DeleteException;
import com.zyx.model.Book;
import com.zyx.model.Library;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.zyx.Util.Utils.getDays;

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
    public void findByName(HttpServletRequest req, HttpServletResponse resp,
                           @ModelAttribute("book")Book book)
            throws ServletException, IOException {
        String name=req.getParameter("bookName");
        //把查询信息暂存到session中
        req.setAttribute("books",bookservice.getSameByBook(book));
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
    @RequestMapping(value = "/admin/books/{id}/delete",method = RequestMethod.GET)
    public String  deleteBook(@PathVariable("id")String  id) {
        try {
            int i =adminService.deleteBook(id);
            if (i==1){
                return "/admin/books";
            }
            else {

                return "forward:/admin/books";
            }
        }catch (BRexception e){

            return "forward:/admin/books";
        }catch (RuntimeException e1){

            return "forward:/admin/books";
        }
    }

    /*
    跳转到更新图书页面
     */
    @RequestMapping(value = "/admin/books/{id}/update",method = RequestMethod.GET)
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
        return "/admin/books";
    }
    /*
    添加图书页面
     */
    @RequestMapping(value = "/admin/books/addBook",method = RequestMethod.GET)
    public String updateBook(){
        return "/admin/add_book";
    }
    /*
    添加图书
     */
    @RequestMapping(value = "/admin/reader/doAddBook",method = RequestMethod.POST)
    public String doAddBook(@ModelAttribute("book")Book book,ModelMap modelMap){
        int result =bookservice.addBook(book);
        if (result==1)
            modelMap.addAttribute("result","添加成功");
        else
            modelMap.addAttribute("result","添加失败");
        return "/admin/books";
    }

/*
*********************************************************************************************
 */


    /*
    获取读者列表
     */
    @RequestMapping(value = "/admin/readers",method = RequestMethod.GET)
    public String getReaders(@ModelAttribute("reader")Reader reader,ModelMap modelMap){
        modelMap.addAttribute("readers",readerservice.findReaders(reader));
        return "/admin/readers";
    }
    /*
    获取读者详情
     */
    @RequestMapping(value = "/admin/readers/{id}/detail",method = RequestMethod.GET)
    public String getReaderDetail(@PathVariable("id")Integer id,ModelMap modelMap){
        Reader reader=readerservice.getById(id);
        modelMap.addAttribute("reader",reader);
        return "/admin/reader_detail";
    }
    /*
     *删除一个读者
     */
    @RequestMapping(value =" /admin/readers/{id}/delete",method = RequestMethod.GET)
    public String deleteReader(@PathVariable("id")Integer id,ModelMap modelMap){
        try {
            int result = readerservice.deleteReader(id);
            if (result == 1)
                return "/admin/readers";
            else {
                throw new DeleteException("删除失败");
            }
        }catch (DeleteException e){
            modelMap.addAttribute("error",e.getMessage());
        }catch (RuntimeException e){
            modelMap.addAttribute("error",e.getMessage());
        }
        return "/admin/readers";
    }
    /*
    跳到更新读者
     */
    @RequestMapping(value = "/admin/readers/{id}/update",method = RequestMethod.GET)
    public String updateReaders(@PathVariable("id")Integer id,ModelMap modelMap){
        modelMap.addAttribute("reader",readerservice.getById(id));
        return "/admin/update_reader";
    }
    /*
    更新读者
     */
    @RequestMapping(value = "/admin/readers/doUpdate",method = RequestMethod.POST)
    public String doUpdateReader(@ModelAttribute("reader")Reader reader,ModelMap modelMap){
        int result =readerservice.updateReader(reader);
        if (result ==1)
            modelMap.addAttribute("result","更新成功,请回到列表刷新");
        else
            modelMap.addAttribute("result","更新失败");
        return "/admin/readers";
    }
    /*
    跳转到添加读者界面
     */
    @RequestMapping(value = "/admin/readers/addReader",method = RequestMethod.GET)
    public String addReader(){
        return "/admin/add_reader";
    }
    /*
    添加读者
     */
    @RequestMapping(value = "/admin/readers/doAddReader",method = RequestMethod.POST)
    public String doAddReader(@ModelAttribute("newReader")Reader newReader,ModelMap modelMap){
        int result =readerservice.addReader(newReader);
        if (result==1)
            modelMap.addAttribute("result","添加成功");
        else
            modelMap.addAttribute("result","添加失败");
        return "/admin/readers";
    }

    /*
     *************************************************************
     */
    /*
     *查看未还的图书
     */
    @RequestMapping(value = "/admin/showNoReturnBook" ,method =RequestMethod.GET )
    public String showNoReturn(ModelMap modelMap){
        //拿出所有没还书的记录
        List<Library> records = libraryservice.findNoReturnReader();
        modelMap.addAttribute("records",records);
        List<Book > books = new ArrayList<Book>();
        for (Library record : records) {
            books.add(bookservice.getById(record.getBookId()));
        }
        modelMap.addAttribute("books",books);
        return "/admin/no_return";
    }
    /*
     * 查看借书超期的 读者
     */
    @RequestMapping(value = "/admin/showOutOfDate",method = RequestMethod.GET)
    public String showOutOfDate(ModelMap modelMap) throws ParseException {
//        modelMap.addAttribute("readers",);
        List<Library > libraries = libraryservice.findNoReturnReader();
        List<Reader> readers = new ArrayList<Reader>();
        for (Library record:libraries) {
            if (getDays(new Date(), record.getBtime()) > 30)
                readers.add(readerservice.getById(record.getReaderId()));
        }
        modelMap.addAttribute("readers",readers);
        return "/admin/outofdate";
    }

//    @RequestMapping(value = "/admin/addReader",method = RequestMethod.POST)
//    public void addReader(@ModelAttribute("reader")Reader reader){
//        int result =readerservice.addReader(reader);
//    }
//    @RequestMapping(value = "/admin/addBook",method = RequestMethod.POST)
//    public void addBook(@ModelAttribute("book")Book book){
//        int result = bookservice.addBook(book);
//    }

    @RequestMapping("/returnMainPage")
    public String  returnMain(){
        return "reader/main";
    }
}
