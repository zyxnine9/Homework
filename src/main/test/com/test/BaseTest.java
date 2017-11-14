package com.test;

import com.zyx.dao.BookMapper;
import com.zyx.dao.ReaderMapper;
import com.zyx.model.Book;
import com.zyx.model.BookExample;
import com.zyx.model.Reader;
import com.zyx.model.ReaderExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTest {

}
