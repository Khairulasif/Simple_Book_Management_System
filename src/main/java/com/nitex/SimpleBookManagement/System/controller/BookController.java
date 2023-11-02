package com.nitex.SimpleBookManagement.System.controller;

import com.nitex.SimpleBookManagement.System.model.Book;
import com.nitex.SimpleBookManagement.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {


    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public void save(@RequestBody Book book) {

        if (book != null) {


            bookService.saveBook(book);

        }

    }

    @GetMapping("/bookList")
    List<Book> bookList() {

        List<Book> books = bookService.bookList();


        return books;
    }

    @PutMapping({"/updateBook/{id}"})
    public void update(@RequestBody Book book, @PathVariable("id") Long id) {
        if (book != null) {
//
            this.bookService.updatedBook(book);
        }

    }


    @GetMapping({"/getBook/{id}"})
    public Book getParticularBook(@PathVariable("id") Long id) {
        Book book = this.bookService.particularBook(id);
        return book;
    }

    @DeleteMapping({"/deleteBook/{id}"})
    public void deleteBook(@PathVariable("id") Long id) {
        this.bookService.deleteBook(id);
    }
}
