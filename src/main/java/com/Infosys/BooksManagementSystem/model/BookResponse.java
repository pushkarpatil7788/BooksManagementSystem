package com.Infosys.BooksManagementSystem.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookResponse {
    private int statusCode;
    private String statusMessage;
    private LocalDate responseDate;
}
