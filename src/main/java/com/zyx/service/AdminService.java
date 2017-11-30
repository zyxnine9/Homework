package com.zyx.service;

import com.zyx.model.Book;
import com.zyx.model.Library;
import com.zyx.model.Reader;

import java.util.List;

public interface AdminService {
    boolean isAdmin(Integer id);

    int updateBook(Book book);

    int updateReader(Reader reader);

    int addReader(Reader reader);

    int addBook(Book book);

    List<Library> showNoReturnReaders(Library library);
}
