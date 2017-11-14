package com.zyx.dao;

import com.zyx.model.Library;
import com.zyx.model.LibraryExample;
import java.util.List;

import com.zyx.model.Reader;
import org.apache.ibatis.annotations.Param;

public interface LibraryMapper {
    int countByExample(LibraryExample example);

    int deleteByExample(LibraryExample example);

    int deleteByPrimaryKey(Integer recod);

    int insert(Library record);

    int insertSelective(Library record);

    List<Library> selectByExample(LibraryExample example);

    Library selectByPrimaryKey(Integer recod);

    int updateByExampleSelective(@Param("record") Library record, @Param("example") LibraryExample example);

    int updateByExample(@Param("record") Library record, @Param("example") LibraryExample example);

    int updateByPrimaryKeySelective(Library record);

    int updateByPrimaryKey(Library record);

    int updateBdays(Integer record);

    List<Reader> getNoReturn();
}