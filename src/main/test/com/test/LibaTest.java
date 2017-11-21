package com.test;

import com.zyx.dao.LibraryMapper;
import com.zyx.model.Library;
import com.zyx.service.Libraryservice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class LibaTest extends BaseTest {
    @Autowired
    LibraryMapper libraryMapper;
    @Autowired
    Libraryservice libraryservice;

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

    @Test
    public void dzz(){
        List<Library> fist=libraryservice.showAll();
        for (int i = 0; i < fist.size(); i++) {
            System.out.println(fist.get(i));
        }
        System.out.println();
        List<Library> second = libraryservice.selectByReaderId(20150001);
        for (int i = 0; i < second.size(); i++) {
            System.out.println(second.get(i));
        }
    }
}

