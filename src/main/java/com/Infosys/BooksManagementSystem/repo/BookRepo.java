package com.Infosys.BooksManagementSystem.repo;

import com.Infosys.BooksManagementSystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {

}
