package com.isett.lab3advenced.bookcatalog.repository;


import com.isett.lab3advenced.bookcatalog.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book save(Book book);
    void delete(Long id);
    boolean existsById(Long id);
}