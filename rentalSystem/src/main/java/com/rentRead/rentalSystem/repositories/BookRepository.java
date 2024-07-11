package com.rentRead.rentalSystem.repositories;

import com.rentRead.rentalSystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
