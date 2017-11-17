package com.zyx.service;

import com.zyx.model.Book;
import com.zyx.model.Reader;

import java.util.List;

public interface Readerservice {
    Reader getByName(String name);

    Reader getById(Integer Id);

    List<Reader> getAll();

    List<Reader> getNoReturn();

    int deleteReader(Integer Id);

    int updateReader(Reader reader);

    List<Reader> findReaders(Reader reader);
}
