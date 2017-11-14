package com.test;

import com.zyx.dao.LibraryMapper;
import com.zyx.model.Library;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class LibaTest extends BaseTest {
    @Autowired
    LibraryMapper libraryMapper;

    @Test
    public void iii(){
        Library library=new Library();
        library.setReaderId(20150001);
        library.setBookId("TP393-1");
        library.setBtime(new Date());
        library.setStatus(0);
        System.out.println(library);
        int i=libraryMapper.insert(library);
        System.out.println("i is "+i);
    }
    @Test
    public  void  ddd(){
        libraryMapper.updateBdays(4);
    }

}

