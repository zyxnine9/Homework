package com.zyx.service;

import com.zyx.model.Library;

import java.util.List;

public interface Libraryservice {
    List<Library> selectByReaderId(Integer readerId);

    List<Library> showAll();

    List<Library> findNoReturnReader();

}
