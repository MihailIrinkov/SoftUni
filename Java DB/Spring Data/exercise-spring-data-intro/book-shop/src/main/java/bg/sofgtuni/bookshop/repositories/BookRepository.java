package bg.sofgtuni.bookshop.repositories;

import bg.sofgtuni.bookshop.domain.entities.Book;
import bg.sofgtuni.bookshop.domain.enums.AgeRestriction;
import bg.sofgtuni.bookshop.domain.enums.EditionType;
import bg.sofgtuni.bookshop.domain.model.BookPrintInformation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<List<Book>> findAllByReleaseDateAfter(LocalDate date);

    Optional<List<Book>> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> getAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer numberOfCopies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBoundary, BigDecimal higherBoundary);

    List<Book> getAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByTitleContains(String contains);

    List<Book> findAllByAuthorLastNameStartingWith(String prefix);

    @Query("Select count(b) From Book b Where length(b.title) > :length")
    Integer findAllByTitleLengthLongerThan(Integer length);

    //    @Query("select new bg.softuni.bookshop.domain.model.BookPrintInformation(b.title, b.editionType, b.ageRestriction,b.price)" +
    //            " from Book b where b.title = :title")
    BookPrintInformation findAllByTitle(String title);

//    @Modifying
//    @Query("delete from Book b where b.copies < :numberOfCopies")
//    int deleteInBooksByCopiesLessThan(int numberOfCopies);

    @Transactional
    int deleteAllByCopiesLessThan(int numberOfCopies);

    @Procedure(value = "usp_get_number_of_written_books_by_author")
    int findBooksByAuthorFirstNameAndAuthorLastname(String fullName);


    List<Book> findAllByReleaseDateAfterOrReleaseDateBefore(LocalDate dateA, LocalDate dateB);

}
