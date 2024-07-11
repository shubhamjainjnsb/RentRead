package com.rentRead.rentalSystem.services;
import com.rentRead.rentalSystem.model.Book;
import com.rentRead.rentalSystem.model.Rental;
import com.rentRead.rentalSystem.model.User;
import com.rentRead.rentalSystem.repositories.BookRepository;
import com.rentRead.rentalSystem.repositories.RentalRepository;
import com.rentRead.rentalSystem.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public RentalService(RentalRepository rentalRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.rentalRepository = rentalRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Rental rentBook(Long userId, Long bookId) {
        if (rentalRepository.countByUserIdAndBookAvailabilityStatusTrue(userId) >= 2) {
            throw new IllegalStateException("User cannot rent more than two books at a time");
        }

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        if (!book.isAvailabilityStatus()) {
            throw new IllegalStateException("Book is not available for rent");
        }

        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        book.setAvailabilityStatus(false);
        bookRepository.save(book);

        Rental rental = new Rental();
        rental.setUser(user);
        rental.setBook(book);
        return rentalRepository.save(rental);
    }

    @Transactional
    public void returnBook(Long userId, Long bookId) {
        Rental rental = rentalRepository.findByUserIdAndBookId(userId, bookId)
                .orElseThrow(() -> new IllegalArgumentException("Rental not found"));

        rentalRepository.delete(rental);

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        book.setAvailabilityStatus(true);
        bookRepository.save(book);
    }
}
