package com.Infosys.BooksManagementSystem.services;

import com.Infosys.BooksManagementSystem.model.Book;

import java.util.List;

public interface BookServiceInterface {
    Book addBook(Book book);
    Book updateBook(int id, Book book);
    void deleteBook(int id);
    Book getBookById(int id);
    List<Book> getAllBooks();

}