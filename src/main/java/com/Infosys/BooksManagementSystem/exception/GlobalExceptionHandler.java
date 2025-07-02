package com.Infosys.BooksManagementSystem.exception;


import com.Infosys.BooksManagementSystem.model.BookResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookException.class)
    public ResponseEntity<BookResponse> handleBookException(BookException ex) {
        BookResponse response = new BookResponse();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setStatusMessage(ex.getMessage());
        response.setResponseDate(LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        BookResponse response = new BookResponse();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setStatusMessage("Validation Failed: " + ex.getBindingResult().getFieldError().getDefaultMessage());
        response.setResponseDate(LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BookResponse> handleGenericException(Exception ex) {
        BookResponse response = new BookResponse();
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setStatusMessage("Something went wrong: " + ex.getMessage());
        response.setResponseDate(LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
