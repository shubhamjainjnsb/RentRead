package com.rentRead.rentalSystem.repositories;
import com.rentRead.rentalSystem.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    long countByUserIdAndBookAvailabilityStatusTrue(Long userId);
    Optional<Rental> findByUserIdAndBookId(Long userId, Long bookId);

}
