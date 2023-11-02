package com.nitex.SimpleBookManagement.System.repository;

import com.nitex.SimpleBookManagement.System.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
