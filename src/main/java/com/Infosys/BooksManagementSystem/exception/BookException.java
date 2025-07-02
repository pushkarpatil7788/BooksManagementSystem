package com.Infosys.BooksManagementSystem.exception;


public class BookException extends RuntimeException {

    public BookException() {
        super("Book not found.");
    }

    public BookException(Long id) {
        super(id + " - Can't find book with this ID");
    }

    public BookException(String message) {
        super(message);
    }
}
