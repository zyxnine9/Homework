package com.zyx.service;

import com.zyx.dao.BookMapper;
import com.zyx.dao.LibraryMapper;
import com.zyx.dao.ReaderMapper;
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

    public List<Library> showNoReturnReaders(Library library) {
        LibraryExample libraryExample = new LibraryExample();
        LibraryExample.Criteria criteria = libraryExample.createCriteria();
        criteria.andBookIdEqualTo(library.getBookId());
        criteria.andReaderIdEqualTo(library.getReaderId());
        return libraryMapper.selectByExample(libraryExample);
    }
}
