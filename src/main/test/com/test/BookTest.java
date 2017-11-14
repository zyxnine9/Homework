package com.test;

import com.zyx.dao.BookMapper;
import com.zyx.model.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookTest extends BaseTest {
    @Autowired
    BookMapper bookMapper;
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
}
