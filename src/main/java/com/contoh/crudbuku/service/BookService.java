package com.contoh.crudbuku.service;

import com.contoh.crudbuku.entity.Book;
import com.contoh.crudbuku.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService  {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
