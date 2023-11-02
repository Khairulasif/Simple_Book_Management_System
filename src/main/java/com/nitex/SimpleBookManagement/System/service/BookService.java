package com.nitex.SimpleBookManagement.System.service;

import com.nitex.SimpleBookManagement.System.model.Book;
import com.nitex.SimpleBookManagement.System.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> bookList() {

        return bookRepository.findAll();
    }

    public void updatedBook(Book book) {

        bookRepository.save(book);
    }

    public Book particularBook(Long id) {
        return (Book)this.bookRepository.findById(id).orElse(new Book());
    }

    public void deleteBook(Long id) {

        bookRepository.deleteById(id);
    }
}
