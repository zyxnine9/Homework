package com.zyx.service;

import com.zyx.dao.LibraryMapper;
import com.zyx.dao.ReaderMapper;
import com.zyx.model.Reader;
import com.zyx.model.ReaderExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReaderserviceImpl implements Readerservice{
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    LibraryMapper libraryMapper;

    ReaderExample readerExample;

    public Reader getByName(String name) {
        return null;
    }

    public Reader getById(Integer Id) {
        return readerMapper.selectByPrimaryKey(Id);
    }

    public List<Reader> getAll() {
        ReaderExample.Criteria criteria = readerExample.createCriteria();
        return readerMapper.selectByExample(readerExample);
    }

    public List<Reader> getNoReturn() {
        return libraryMapper.getNoReturn();
    }

    public int deleteReader(Integer Id) {
        try {
            int i=readerMapper.deleteByPrimaryKey(Id);
            return i;
        }catch (Exception e){
            e.getMessage();
            return 0;
        }
    }

    public int updateReader(Reader reader) {
        return readerMapper.updateByExampleSelective(reader);
    }
}
