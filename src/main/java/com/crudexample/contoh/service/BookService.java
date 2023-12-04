package com.crudexample.contoh.service;
import java.util.List;
import com.crudexample.contoh.entity.Book;

public interface BookService {
    List<Book> getAllBooks();
    Book saveBook(Book book);
}
