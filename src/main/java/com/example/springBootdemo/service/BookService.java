package com.example.springBootdemo.service;

import com.example.springBootdemo.model.Book;
import com.example.springBootdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(Long id)
    {
        return bookRepository.getOne(id);
    }
    public List<Book> findAll()
    {
        return bookRepository.findAll();
    }
    public Book saveBook(Book book)
    {
        return bookRepository.save(book);
    }
    public void deleteBook(Long id)
    {
        bookRepository.deleteById(id);
    }
}
