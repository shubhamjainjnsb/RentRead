package com.rentRead.rentalSystem.controller;
import com.rentRead.rentalSystem.model.Rental;
import com.rentRead.rentalSystem.services.RentalService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/books/{bookId}/rent")
    public ResponseEntity<Rental> rentBook(@PathVariable Long bookId, @RequestParam Long userId) {
        return ResponseEntity.ok(rentalService.rentBook(userId, bookId));
    }

    @PostMapping("/books/{bookId}/return")
    public ResponseEntity<Void> returnBook(@PathVariable Long bookId, @RequestParam Long userId) {
        rentalService.returnBook(userId, bookId);
        return ResponseEntity.noContent().build();
    }
}
