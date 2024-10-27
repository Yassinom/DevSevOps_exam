package com.example.demo.contoller;


import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public boolean addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PostMapping("/deleteBook/{title}")
    public boolean deleteBook(@PathVariable String title) {
        return bookService.deleteBook(title);
    }

    @GetMapping("/salam")
    public String salam() {
        return "salam";
    }
}
