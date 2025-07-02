package com.Infosys.BooksManagementSystem.services;

import com.Infosys.BooksManagementSystem.exception.BookException;
import com.Infosys.BooksManagementSystem.model.Book;
import com.Infosys.BooksManagementSystem.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book updateBook(int id, Book book) {
        Book existingBook = bookRepo.findById(id)
                .orElseThrow(() -> new BookException((long) id));  // changed
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        return bookRepo.save(existingBook);
    }

    @Override
    public void deleteBook(int id) {
        if (!bookRepo.existsById(id)) {
            throw new BookException((long) id); // changed
        }
        bookRepo.deleteById(id);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new BookException((long) id)); // changed
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}
