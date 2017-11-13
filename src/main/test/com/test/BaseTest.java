package com.test;

import com.zyx.dao.ReaderMapper;
import com.zyx.model.Reader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTest {
    @Autowired
    ReaderMapper readerMapper;
    @Test
    public void find() {
        Reader reader = readerMapper.selectByPrimaryKey(20150001);
        System.out.println(reader);
    }
}
