package com.example.demo.service;


import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public boolean addBook(Book book) {
        if (book != null) {
            bookRepository.save(book);
            return true;
        } return false;
    }

    public boolean deleteBook(String title) {
        Book book = bookRepository.findByTitle(title);
        if (book != null) {
            bookRepository.delete(book);
            return true;
        } return false;
    }

}
