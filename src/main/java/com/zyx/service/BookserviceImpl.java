package com.zyx.service;

import com.zyx.dao.BookMapper;
import com.zyx.dao.LibraryMapper;
import com.zyx.exception.NobkException;
import com.zyx.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BookserviceImpl implements Bookservice {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    LibraryMapper libraryMapper;

    BookExample bookExample;

    public Book getById(String Id) {
        return bookMapper.selectByPrimaryKey(Id);
    }

    public List<Book> getByName(String Name) {
        bookExample =new BookExample();
        BookExample.Criteria criteria=bookExample.createCriteria();
        criteria.andNameLike("%"+Name+"%");
        return bookMapper.selectByExample(bookExample);
    }

    public List<Book> getAll() {
        bookExample=new BookExample();
        return bookMapper.selectByExample(bookExample);
    }

    public int deleteBookById(String Id) {
        return bookMapper.deleteByPrimaryKey(Id);
    }

    public int addBook(Book book) {
        try{
            bookMapper.insert(book);
            return 1;
        }catch(Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int updateBook(Book book) {
        BookExample.Criteria criteria=bookExample.createCriteria();
        criteria.andIdEqualTo(book.getId());
        return bookMapper.updateByExampleSelective(book,bookExample);
    }

    public int borrowBook(Book book, Reader reader) {
        Library library =new Library();
        library.setBookId(book.getId());
        library.setReaderId(reader.getId());
        library.setBtime(new Date());
        library.setStatus(0);
        try {
            int number=bookMapper.reduceNumber(book.getId());
            if(number<=0){
                throw new NobkException("该书没有库存了");
            }else {
                int insert =libraryMapper.insert(library);
            }
        }catch (NobkException e1){
            throw e1;
        }
        return 1;
    }

    public int returnBook(Library library) {
        library.setRtime(new Date());
        library.setStatus(1);
        libraryMapper.updateByPrimaryKeySelective(library);
        libraryMapper.updateBdays(library.getRecod());
        bookMapper.increaseNumber(library.getBookId());
        return 1;
    }

}
