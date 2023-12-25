package com.contoh.crudbuku.controller;

import com.contoh.crudbuku.entity.Author;
import com.contoh.crudbuku.entity.Book;
import com.contoh.crudbuku.service.AuthorService;
import com.contoh.crudbuku.service.BookService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    private BookService bookService;
    private AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    // Handler methods to handle list books and return mode and view
    @GetMapping("/app/sukaperpus/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/app/sukaperpus/books/new")
    public String createBookForm(Model model) {
        Book book = new Book();
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("book", book);
        model.addAttribute("authors", authors);
        return "create_book";
    }

    @PostMapping("/app/sukaperpus/books")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/app/sukaperpus/books";
    }
    
    @GetMapping("/app/sukaperpus/books/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "edit_book";
    }

    @PostMapping("/app/sukaperpus/books/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute("book") Book book) {
        Book existingBook = bookService.getBookById(id);
        existingBook.setIsbn(book.getIsbn());
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setYear(book.getYear());
        bookService.updateBook(existingBook);
        return "redirect:/app/sukaperpus/books";
    }
    
    @GetMapping("/app/sukaperpus/books/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/app/sukaperpus/books";
    }

    @GetMapping("/app/sukaperpus/books/info/{id}")
    public String showBookDetail(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "book_detail";
    }
}
