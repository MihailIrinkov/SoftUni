package bg.sofgtuni.bookshop.service;

import bg.sofgtuni.bookshop.domain.entities.Book;
import bg.sofgtuni.bookshop.domain.model.BookPrintInformation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {

    boolean isDataSeeded();

    void seedBooks(List<Book> books);

    List<Book> getAllBooksAfterYear(LocalDate date);

    List<Book> getAllBooksBeforeYear(LocalDate date);

    List<Book> getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> getAllByAgeRestriction(String ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThen(String editionType, Integer numberOfCopies);

    List<Book> findAllByPriceLessOrGreater(BigDecimal lowerBoundary, BigDecimal higherBoundary);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> getAllByTitleContaining(String contains);

    List<Book> getAllByAuthorLastNameStartingWith(String prefix);

    Integer getAllByTitleLengthLongerThan(Integer length);

    BookPrintInformation getAllByTitle(String title);

    void increaseCopiesAfterGivenYear(Integer numberOfCopies, LocalDate date);

//    int deleteInBooksByCopiesLessThan(int numberOfCopies);

    int deleteAllByCopiesLessThan(int numberOfCopies);

    int findBooksByAuthorFirstNameAndAuthorLastname(String fullName);

    List<Book> getAllByReleaseDateAfterAndReleaseDateBefore(LocalDate dateA, LocalDate dateB);
}
