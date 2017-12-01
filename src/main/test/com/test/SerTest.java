package com.test;

import com.zyx.dao.ReaderMapper;
import com.zyx.model.Book;
import com.zyx.model.Library;
import com.zyx.model.Reader;
import com.zyx.service.AdminService;
import com.zyx.service.Bookservice;
import com.zyx.service.BookserviceImpl;
import com.zyx.service.Libraryservice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class SerTest extends BaseTest {
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    Libraryservice libraryservice;
    @Autowired
    Bookservice bookservice;
    @Autowired
    AdminService adminService;

    @Test
    public void borrow(){
        Library library= new Library();
        library.setReaderId(20150001);
        library.setBookId("TP393-1");
        bookservice.borrowBook(library);
    }
    @Test
    public void rrrr(){
        Library library= new Library();
        library.setReaderId(20150001);
        library.setBookId("TP393-1");
        try {
            bookservice.returnBook(library);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



    @Test
    public void S(){
//        readerMapper.insert(reader);
    }
}
