package com.test;

import com.zyx.exception.BRexception;
import com.zyx.model.Book;
import com.zyx.model.Reader;
import com.zyx.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminTest extends BaseTest {
    @Autowired
    AdminService adminService;

    @Test
    public void zzzz(){
        try {
            Reader reader = new Reader();
            Book book = new Book();
            book.setId("TP393-1");
            reader.setId(20150001);
            adminService.deleteBook("T3");
//            adminService.deleteReader(reader);
        }catch (BRexception e){
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void j(){
        try {
            int i=adminService.deleteBook("TA331-123");
            System.out.println("ok"+i);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
