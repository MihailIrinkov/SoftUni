package bg.sofgtuni.bookshop.service;

import bg.sofgtuni.bookshop.domain.entities.Book;
import bg.sofgtuni.bookshop.domain.enums.AgeRestriction;
import bg.sofgtuni.bookshop.domain.enums.EditionType;
import bg.sofgtuni.bookshop.domain.model.BookPrintInformation;
import bg.sofgtuni.bookshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    final BookRepository bookRepository;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public void seedBooks(List<Book> books) {
        this.bookRepository.saveAllAndFlush(books);
    }

    @Override
    public List<Book> getAllBooksAfterYear(LocalDate date) {
        List<Book> allByReleaseDateAfter = this.bookRepository.findAllByReleaseDateAfter(date).get();

        System.out.println(allByReleaseDateAfter.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("\n"))
                .toString());

        return allByReleaseDateAfter;
    }

    @Override
    public List<Book> getAllBooksBeforeYear(LocalDate date) {
        return this.bookRepository.findAllByReleaseDateBefore(date)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName) {
        final List<Book> books = this.bookRepository
                .findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(
                        firstName, lastName);

        books.stream()
                .map(Book::getBookTitleReleaseDateCopiesFormat)
                .forEach(System.out::println);

        return books;
    }

    @Override
    public List<Book> getAllByAgeRestriction(String ageRestriction) {
        final List<Book> allByAgeRestriction = this.bookRepository
                .getAllByAgeRestriction(AgeRestriction.valueOf(ageRestriction.toUpperCase()));

        allByAgeRestriction.stream()
                .map(b -> b.getTitle())
                . forEach(System.out::println);

        return allByAgeRestriction;
    }

    @Override
    public List<Book> findAllByEditionTypeAndCopiesLessThen(String editionType, Integer numberOfCopies) {
        final List<Book> allByEditionTypeAndCopiesLessThen = this.bookRepository
                .findAllByEditionTypeAndCopiesLessThan(EditionType.valueOf(editionType.toUpperCase()), numberOfCopies);

        allByEditionTypeAndCopiesLessThen.stream()
                .forEach(b -> System.out.println(b.getTitle()));

        return allByEditionTypeAndCopiesLessThen;
    }

    @Override
    public List<Book> findAllByPriceLessOrGreater(BigDecimal lowerBoundary, BigDecimal higherBoundary) {
        final List<Book> books = this.bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan(lowerBoundary, higherBoundary);

        books.forEach(b -> System.out.println(b.printNameAndPriceFormat()));

        return books;
    }

    @Override
    public List<Book> findAllByReleaseDateBefore(LocalDate date) {
        final List<Book> allByReleaseDateBefore =
                this.bookRepository.getAllByReleaseDateBefore(date);

        allByReleaseDateBefore.forEach(b -> System.out.println(b.getBookTitleEditionTypeAndPrice()));

        return allByReleaseDateBefore;
    }

    @Override
    public List<Book> getAllByTitleContaining(String contains) {
        final List<Book> bookList = this.bookRepository.findAllByTitleContains(contains);

        bookList.forEach(b -> System.out.println(b.getTitle()));

        return bookList;
    }

    @Override
    public List<Book> getAllByAuthorLastNameStartingWith(String prefix) {
        final List<Book> bookList = this.bookRepository.findAllByAuthorLastNameStartingWith(prefix);

        bookList.forEach(b -> System.out.printf("%s (%s)%n", b.getTitle(), b.getAuthor().getAuthorFullName()));

        return bookList;
    }

    @Override
    public Integer getAllByTitleLengthLongerThan(Integer length) {
        final Integer numberOfBooks = this.bookRepository.findAllByTitleLengthLongerThan(length);


        System.out.printf("There are %d books with longer titles than %d symbols.%n", numberOfBooks, length);
        return numberOfBooks;
    }

    @Override
    public BookPrintInformation getAllByTitle(String title) {

        final BookPrintInformation allByTitle = this.bookRepository.findAllByTitle(title);

        System.out.println(allByTitle);
        return allByTitle;
    }

    @Override
    public void increaseCopiesAfterGivenYear(Integer numberOfCopies, LocalDate date) {
        final List<Book> bookList = this.bookRepository.findAllByReleaseDateAfter(date).get();

        for (Book book : bookList) {
            book.setCopies(book.getCopies() + numberOfCopies);
            this.bookRepository.saveAndFlush(book);
        }

        System.out.println(bookList.size() * numberOfCopies);
        System.out.println(bookList.stream().mapToInt(b -> b.getCopies()).sum());
    }

    @Override
    public int deleteAllByCopiesLessThan(int numberOfCopies) {
        final int number = this.bookRepository.deleteAllByCopiesLessThan(numberOfCopies);

        System.out.println(number);

        return number;
    }

    @Override
    public int findBooksByAuthorFirstNameAndAuthorLastname(String fullName) {
        final int bookCountByAuthor = this.bookRepository.findBooksByAuthorFirstNameAndAuthorLastname(fullName);

        System.out.println(bookCountByAuthor);

        return bookCountByAuthor;
    }

    @Override
    public List<Book> getAllByReleaseDateAfterAndReleaseDateBefore(LocalDate dateA, LocalDate dateB) {
        final List<Book> bookList = this.bookRepository.findAllByReleaseDateAfterOrReleaseDateBefore(dateA, dateB);

        if(bookList.isEmpty()) {
            System.out.println("NO BOOKS TO DISPLAY");
        }

        System.out.println(bookList.stream().map(b -> b.getTitle()).collect(Collectors.joining("\n")));

        return bookList;
    }

}
