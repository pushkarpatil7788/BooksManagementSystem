package com.Infosys.BooksManagementSystem.controller;

import com.Infosys.BooksManagementSystem.model.Book;
import com.Infosys.BooksManagementSystem.model.BookResponse;
import com.Infosys.BooksManagementSystem.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class Bookcontroller {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody Book book) {
        bookService.addBook(book);

        BookResponse response = new BookResponse();
        response.setStatusCode(201);
        response.setStatusMessage("Book Added Successfully");
        response.setResponseDate(LocalDate.now());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable int id, @RequestBody Book book) {
        bookService.updateBook(id, book);

        BookResponse response = new BookResponse();
        response.setStatusCode(200);
        response.setStatusMessage("Book Updated Successfully");
        response.setResponseDate(LocalDate.now());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookResponse> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);

        BookResponse response = new BookResponse();
        response.setStatusCode(200);
        response.setStatusMessage("Book Deleted Successfully with ID: " + id);
        response.setResponseDate(LocalDate.now());

        return ResponseEntity.ok(response);
    }
}
