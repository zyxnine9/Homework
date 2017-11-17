package com.test;

import com.zyx.dao.LibraryMapper;
import com.zyx.dao.ReaderMapper;
import com.zyx.model.Reader;
import com.zyx.model.ReaderExample;
import com.zyx.service.ReaderserviceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class Readtest extends BaseTest {
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    LibraryMapper libraryMapper;
    @Autowired
    ReaderserviceImpl a;

    @Test
    public void ii(){
        List<Reader> readers=libraryMapper.getNoReturn();
        for(int i=0;i<readers.size();i++){
            System.out.println(readers.get(i));
        }
    }

    @Test
    public void ssss(){
        Reader reader= new Reader();
        reader.setName("张");
//        reader.setSex("女");
        ReaderExample example = new ReaderExample();
        ReaderExample.Criteria criteria=example.createCriteria();
        List<Reader> readers=a.findReaders(reader);
        for (int i = 0; i <readers.size() ; i++) {
            System.out.println(readers.get(i));
        }
    }

}
