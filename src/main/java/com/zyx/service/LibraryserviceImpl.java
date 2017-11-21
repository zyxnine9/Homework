package com.zyx.service;

import com.zyx.dao.LibraryMapper;
import com.zyx.model.Library;
import com.zyx.model.LibraryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryserviceImpl implements Libraryservice {
    @Autowired
    LibraryMapper libraryMapper;

    public List<Library> selectByReaderId(Integer readerId) {
        LibraryExample libraryExample =new LibraryExample();
        LibraryExample.Criteria criteria= libraryExample.createCriteria();
        criteria.andReaderIdEqualTo(readerId);
        return libraryMapper.selectByExample(libraryExample);
    }

    public List<Library> showAll() {
        LibraryExample libraryExample =new LibraryExample();
        return libraryMapper.selectByExample(libraryExample);
    }

    public int findNoReturnReader(Integer readerId) {
        LibraryExample libraryExample = new LibraryExample();
        LibraryExample.Criteria criteria =libraryExample.createCriteria();
        //已经还书的记录
        criteria.andStatusEqualTo(1);
        criteria.andReaderIdEqualTo(readerId);
        return libraryMapper.selectByExample(libraryExample).size();
    }


}
