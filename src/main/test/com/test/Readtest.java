package com.test;

import com.zyx.dao.LibraryMapper;
import com.zyx.dao.ReaderMapper;
import com.zyx.model.Reader;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Readtest extends BaseTest {
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    LibraryMapper libraryMapper;

    @Test
    public void ii(){

        List<Reader> readers=libraryMapper.getNoReturn();
        for(int i=0;i<readers.size();i++){
            System.out.println(readers.get(i));
        }
    }

}
