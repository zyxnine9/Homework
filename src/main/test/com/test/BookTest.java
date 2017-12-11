package com.test;

import com.zyx.dao.BookMapper;
import com.zyx.model.Book;
import com.zyx.model.BookExample;
import com.zyx.model.Library;
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
    public void zzd(){
        Book book =new Book();
        book.setWriter("王菲");
        List<Book > books =bookservice.getSameByBook(book);
        for (Book b:
             books) {
            System.out.println(b);
        }
    }

    @Test
    public void vbb(){
        Library library = new Library();
        library.setBookId("TP393-4");
        library.setReaderId(20150001);
        System.out.println(bookservice.borrowBook(library));
    }
    public void ret(){
        Library library = new Library();
        library.setBookId("TP393-4");
        library.setReaderId(20150001);
        bookservice.returnBook(library);
    }

    @Test
    public void getall(){
        List<Book> books=bookservice.getAll();
        for (int i = 0; i <books.size() ; i++) {
            System.out.println(books.get(i));
        }
    }

    @Test
    public void update(){
        Book book = new Book();
        book.setId("TA331-123");
        book.setName("JAVA程序设计");
        book.setName("爱德华");
        book.setBkcontext("java的程序设计书");
        bookservice.updateBook(book);
    }
}
