package com.zyx.service;

import com.zyx.dao.LibraryMapper;
import com.zyx.dao.ReaderMapper;
import com.zyx.model.Reader;
import com.zyx.model.ReaderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderserviceImpl implements Readerservice{
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    LibraryMapper libraryMapper;

    public Reader getByName(String name) {
        return null;
    }

    public Reader getById(Integer Id) {
        return readerMapper.selectByPrimaryKey(Id);
    }

    public List<Reader> getAll() {
        ReaderExample readerExample =new ReaderExample();
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
        ReaderExample readerExample = new ReaderExample();
        ReaderExample.Criteria criteria=readerExample.createCriteria();
        criteria.andIdEqualTo(reader.getId());
        return readerMapper.updateByExampleSelective(reader,readerExample);
    }

    public List<Reader> findReaders(Reader reader){
        ReaderExample readerExample = new ReaderExample();
        ReaderExample.Criteria criteria=readerExample.createCriteria();
        if (reader.getId()!=null)
            criteria.andIdEqualTo(reader.getId());
        if (reader.getName()!=null&&reader.getName().trim().length()!=0)
            criteria.andNameLike("%"+reader.getName()+"%");
        if (reader.getSex()!=null&&reader.getSex().trim().length()!=0)
            criteria.andSexEqualTo(reader.getSex());
        if (reader.getDept()!=null&&reader.getDept().trim().length()!=0)
            criteria.andDeptLike("%"+reader.getDept()+"%");
        if (reader.getGrade()!=null&&reader.getGrade().trim().length()!=0)
            criteria.andGradeLike("%"+reader.getGrade()+"%");
        return readerMapper.selectByExample(readerExample);
        }

    public Reader getUserByIdAndKey(Integer id, String key) {
        return readerMapper.login(id,key);
    }

    public int addReader(Reader reader) {
        return readerMapper.insert(reader);
    }
}

