package com.test;

import com.zyx.dao.BookMapper;
import com.zyx.model.Book;
import com.zyx.service.Bookservice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookTest extends BaseTest {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    Bookservice bookservice;
    @Test
    public void sss(){
        int i = bookMapper.reduceNumber("TP393-1");
        System.out.println("i is "+i);
    }
    @Test
    public void samebook(){
        Book book =new Book();
        book.setId("TP393-1");
        bookMapper.insert(book);
    }

    @Test
    public void getall(){
        List<Book> books=bookservice.getAll();
        for (int i = 0; i <books.size() ; i++) {
            System.out.println(books.get(i));
        }
    }
}
