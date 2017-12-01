package com.zyx.service;

import com.zyx.dao.BookMapper;
import com.zyx.dao.LibraryMapper;
import com.zyx.dao.ReaderMapper;
import com.zyx.exception.BRexception;
import com.zyx.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    BookMapper bookMapper;
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    LibraryMapper libraryMapper;


    public boolean isAdmin(Integer id) {
        Reader admin =readerMapper.selectByPrimaryKey(id);
        if (admin!=null&&admin.getAuthority()==2)
            return true;
        else
            return false;
    }

    public int updateBook(Book book) {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andIdEqualTo(book.getId());
        return bookMapper.updateByExampleSelective(book,bookExample);
    }

    public int updateReader(Reader reader) {
        ReaderExample readerExample = new ReaderExample();
        ReaderExample.Criteria criteria = readerExample.createCriteria();
        criteria.andIdEqualTo(reader.getId());
        return readerMapper.updateByExampleSelective(reader,readerExample);
    }


    public int addReader(Reader reader) {
        return readerMapper.insert(reader);
    }

    public int addBook(Book book) {
        return bookMapper.insert(book);
    }

    public List<Library> showNoReturnReaders() {
        LibraryExample libraryExample = new LibraryExample();
        LibraryExample.Criteria criteria = libraryExample.createCriteria();
        criteria.andStatusEqualTo(0);
        return libraryMapper.selectByExample(libraryExample);
    }

    public int deleteBook(String id) {
        try {
            LibraryExample libraryExample = new LibraryExample();
            LibraryExample.Criteria criteria = libraryExample.createCriteria();
            criteria.andBookIdEqualTo(id);
            criteria.andStatusEqualTo(0);
            List<Library> libraries = libraryMapper.selectByExample(libraryExample);
            if (libraries.size() != 0) {
                //说明这本书在外借，不能删除
                throw new BRexception("该书正在被外借，不能删除");
            } else {
                LibraryExample delete = new LibraryExample();
                LibraryExample.Criteria delete_cri = delete.createCriteria();
                delete_cri.andStatusEqualTo(1);
                delete_cri.andBookIdEqualTo(id);
                libraryMapper.deleteByExample(delete);
                //删除图书管理的记录,再删除书
                return bookMapper.deleteByPrimaryKey(id);
            }
        }catch(BRexception e){
                throw e;
            }
//        return 0;
    }

    public int deleteReader(Integer id) {
        try {
            LibraryExample libraryExample = new LibraryExample();
            LibraryExample.Criteria criteria = libraryExample.createCriteria();
            criteria.andReaderIdEqualTo(id);
            criteria.andStatusEqualTo(0);
            List<Library> libraries = libraryMapper.selectByExample(libraryExample);
            if (libraries != null) {
                //说明人在借书，不能删除
                throw new BRexception("该人正在借书，不能删除");
            } else {
                LibraryExample delete = new LibraryExample();
                LibraryExample.Criteria delete_cri = delete.createCriteria();
                delete_cri.andStatusEqualTo(1);
                delete_cri.andReaderIdEqualTo(id);
                libraryMapper.deleteByExample(delete);
                //删除图书管理的记录,再删除人
                return readerMapper.deleteByPrimaryKey(id);
            }
        }catch(BRexception e){
            throw e;
        }
    }


}
