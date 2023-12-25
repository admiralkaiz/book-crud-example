package com.contoh.crudbuku.controller;

import com.contoh.crudbuku.entity.Author;
import com.contoh.crudbuku.service.AuthorService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Handler methods to handle list books and return mode and view
    @GetMapping("/app/sukaperpus/authors")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    @GetMapping("/app/sukaperpus/authors/new")
    public String createAuthorForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "create_author";
    }

    @PostMapping("/app/sukaperpus/authors")
    public String saveAuthor(@ModelAttribute("author") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/app/sukaperpus/authors";
    }
    
    @GetMapping("/app/sukaperpus/authors/edit/{id}")
    public String editAuthorForm(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorService.getAuthorById(id));
        return "edit_author";
    }

    @PostMapping("/app/sukaperpus/authors/{id}")
    public String updateAuthor(@PathVariable Long id, @ModelAttribute("author") Author author) {
        Author existingAuthor = authorService.getAuthorById(id);
        existingAuthor.setName(author.getName());
        authorService.updateAuthor(existingAuthor);
        return "redirect:/app/sukaperpus/authors";
    }
    
    @GetMapping("/app/sukaperpus/authors/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
        return "redirect:/app/sukaperpus/authors";
    }

    @GetMapping("/app/sukaperpus/authors/info/{id}")
    public String showAuthorDetail(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorService.getAuthorById(id));
        return "author_detail";
    }
}

