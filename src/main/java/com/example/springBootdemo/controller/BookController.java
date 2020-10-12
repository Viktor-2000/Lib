package com.example.springBootdemo.controller;

import com.example.springBootdemo.model.Book;
import com.example.springBootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    @PreAuthorize("hasAnyAuthority('user:librarian','user:read')")
    public String findAll(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books",books);
        return "book-list";
    }


    @GetMapping("/book-add")
    @PreAuthorize("hasAuthority('user:librarian')")
    public String AddBookForm(Book book){
        return "book-add";
    }

    @PostMapping("/book-add")
    @PreAuthorize("hasAuthority('user:librarian')")
    public String addBook(Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/book-delete/{id}")
    @PreAuthorize("hasAuthority('user:librarian')")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return"redirect:/books";
    }

    @GetMapping("/book-update/{id}")
    @PreAuthorize("hasAuthority('user:librarian')")
    public String updateBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book-update";
    }
    @PostMapping("/book-update")
    @PreAuthorize("hasAuthority('user:librarian')")
    public String updateUser(Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }
}
