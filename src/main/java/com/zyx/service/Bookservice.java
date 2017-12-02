package com.zyx.service;

import com.zyx.model.Book;
import com.zyx.model.Library;
import com.zyx.model.Reader;

import java.util.List;

public interface Bookservice {
    Book getById(String Id);

    List<Book> getByName(String Name);

    List<Book> getAll();

    int deleteBookById(String Id);

    int addBook(Book book);

    int updateBook(Book book);

    int borrowBook(Library library);

    int returnBook(Library library);

}
