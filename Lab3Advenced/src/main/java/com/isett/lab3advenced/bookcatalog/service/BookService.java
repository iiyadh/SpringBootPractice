package com.isett.lab3advenced.bookcatalog.service;


import com.isett.lab3advenced.bookcatalog.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findBookById(Long id);
    Book createBook(Book book);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}