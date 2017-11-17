package com.zyx.service;

import com.zyx.dao.BookMapper;
import com.zyx.dao.LibraryMapper;
import com.zyx.dao.ReaderMapper;
import com.zyx.exception.BRexception;
import com.zyx.exception.NobkException;
import com.zyx.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookserviceImpl implements Bookservice {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    LibraryMapper libraryMapper;
    @Autowired
    ReaderMapper readerMapper;

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

    public int borrowBook(Library library) {
        library.setBtime(new Date());
        library.setStatus(0);
        try {
            Reader reader=readerMapper.selectByPrimaryKey(library.getReaderId());
            Book book=bookMapper.selectByPrimaryKey(library.getBookId());
            if(reader==null){
                throw new BRexception("没有这个读者");
            }
            if (book==null){
                throw  new NobkException("馆内没有这本书");
            }
            int number=bookMapper.reduceNumber(library.getBookId());
            if(number<=0){
                throw new NobkException("该书没有库存了");
            }else {
                libraryMapper.insert(library);
                return 1;
            }
        }catch (BRexception e){
            throw e;
        } catch (NobkException e1){
            throw e1;
        }catch (RuntimeException e2){
            throw e2;
        }
    }

    public int returnBook(Library library) {
        try {
            LibraryExample libraryExample = new LibraryExample();
            LibraryExample.Criteria criteria = libraryExample.createCriteria();
            criteria.andReaderIdEqualTo(library.getReaderId());
            criteria.andBookIdEqualTo(library.getBookId());
            List<Library> list = libraryMapper.selectByExample(libraryExample);
            if (list.size() == 0)
                throw new BRexception("没有借阅记录");
            else {
                library.setRtime(new Date());
                library.setStatus(1);
                library.setRecod(list.get(0).getRecod());
                libraryMapper.updateByPrimaryKeySelective(library);
                libraryMapper.updateBdays(library.getRecod());
                bookMapper.increaseNumber(library.getBookId());
                return 1;
            }
        } catch (BRexception e){
            throw e;
        }
    }

}
