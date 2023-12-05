package com.contoh.crudbuku.service;

import com.contoh.crudbuku.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book saveBook(Book book);
    Book getBookById(Long id);
    Book updateBook(Book book);
    void deleteBookById(Long id);
}
