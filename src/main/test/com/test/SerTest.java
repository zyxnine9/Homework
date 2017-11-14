package com.test;

import com.zyx.dao.ReaderMapper;
import com.zyx.model.Book;
import com.zyx.model.Reader;
import com.zyx.service.BookserviceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class SerTest extends BaseTest {
    @Autowired
    ReaderMapper readerMapper;

    @Test
    public void S(){
//        readerMapper.insert(reader);
    }
}
