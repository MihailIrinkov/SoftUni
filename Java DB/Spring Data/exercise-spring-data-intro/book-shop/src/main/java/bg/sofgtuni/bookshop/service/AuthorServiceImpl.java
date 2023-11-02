package bg.sofgtuni.bookshop.service;

import bg.sofgtuni.bookshop.domain.entities.Author;
import bg.sofgtuni.bookshop.domain.entities.Book;
import bg.sofgtuni.bookshop.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

//@Service
//public class AuthorServiceImpl implements AuthorService {
//
//    private final AuthorRepository authorRepository;
//    private final BookService bookService;
//
//    @Autowired
//    public AuthorServiceImpl(AuthorRepository authorRepository, BookService bookService) {
//        this.authorRepository = authorRepository;
//        this.bookService = bookService;
//    }
//
//    @Override
//    public boolean isDataSeeded() {
//        return this.authorRepository.count() > 0;
//    }
//
//    @Override
//    public void seedAuthors(List<Author> authors) {
//        this.authorRepository.saveAllAndFlush(authors);
//    }
//
////    @Override
////    public Author getRandomAuthor() {
////
////        final long count = this.authorRepository.count();
////
////        if (count != 0) {
////            long randomId = new Random().nextLong(1L, count) + 1L;
////            return this.authorRepository.findById(randomId)
////                    .orElseThrow(NoSuchElementException::new);
////        }
////        throw new RuntimeException();
////    }
//
//    @Override
//    public Author getRandomAuthor() {
//        final long count = this.authorRepository.count();
//
//        if (count != 0) {
//            long randomId = new Random().nextLong(1L, count) + 1L;
//            return this.authorRepository.findById(randomId).orElseThrow(NoSuchElementException::new);
//        }
//
//        throw new RuntimeException();
//    }
//
//    @Override
//    public List<Author> getAllAuthorsWithBooksBeforeYear(LocalDate date) {
//        final List<Author> authors = this.bookService.getAllBooksBeforeYear(date)
//                .stream()
//                .map(Book::getAuthor)
//                .toList();
//
//        System.out.println(authors.stream().map(Author::getAuthorFullName)
//                .collect(Collectors.joining("\n")));
//        return authors;
//    }
//
//    @Override
//    public List<Author> getAllAuthorsByBooksCountDesc() {
//
//        List<Author> authors = this.authorRepository
//                .findAllDistinctOrderByBooksSize().orElseThrow(NoSuchElementException::new);
//
//        System.out.println(authors.stream()
//                .map(a -> a.getAuthorFullNameAndCountOfBooks())
//                .collect(Collectors.joining("\n")));
//
//        return authors;
//    }
//
//
//}




// by presumption all entities have to have a service that will manipulate the info from the database
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookService bookService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }

    @Override
    public boolean isDataSeeded() {
        return this.authorRepository.count() > 0;
    }

    @Override
    public void seedAuthors(List<Author> authors) {
        this.authorRepository.saveAllAndFlush(authors);
    }

    @Override
    public Author getRandomAuthor() {
        final long count = this.authorRepository.count();

        if (count != 0) {
            long randomId = new Random().nextLong(1L, count) + 1L;
            return this.authorRepository.findById(randomId).orElseThrow(NoSuchElementException::new);
        }

        throw new RuntimeException();
    }

    @Override
    public List<Author> getAllAuthorsWithBooksBeforeYear(LocalDate date) {
        final List<Author> authors = this.bookService.getAllBooksBeforeYear(date)
                .stream()
                .map(Book::getAuthor)
                .toList();

        System.out.println(authors.stream()
                .map(Author::getAuthorFullName)
                .collect(Collectors.joining("\n")));

        return authors;
    }

    @Override
    @Transactional
    public List<Author> getAllAuthorsOrderByBooksDesc() {
        final List<Author> authors = this.authorRepository
                .findAllDistinctOrderByBooks();

        System.out.println(authors.stream()
                .map(Author::getAuthorFullNameAndCountOfBooks)
                .collect(Collectors.joining("\n")));

        return authors;
    }

    @Override
    public List<Author> getAllByFirstNameEndingWith(String suffix) {
        final List<Author> authors = this.authorRepository.findAllByFirstNameEndingWith(suffix);

        authors.forEach(a -> System.out.println(a.getAuthorFullName()));

        return authors;
    }

    @Override
    public List<Author> getAll() {

        final List<Author> authorList = this.authorRepository.findAll();

        authorList.sort(Comparator.comparing(Author::getAllCopies).reversed());

                // .sorted((a, b) -> a.getAllCopies() > b.getAllCopies());

        System.out.println(authorList.stream()
                    .map(Author::getAuthorFullNameAndCountOfBooksCopies)
                    .collect(Collectors.joining("\n")));
//        final List<Author> authorList = this.authorRepository.findAll();
//
//        for (Author a : authorList) {
//
//            System.out.println(a.books.stream().map(b -> b.getCopies()));
//        }

        return authorList;
    }


//    @Override
//    public List<Author> getAllByFirstNameEndingWith(String suffix) {
//        final List<Author> authors = this.authorRepository
//                .findAllByFirstNameEndingWith(suffix);
//
//        authors.forEach(a -> System.out.println(a.getAuthorFullName()));
//
//        return authors;
//    }
}