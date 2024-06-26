package bg.sofgtuni.bookshop.service;

import bg.sofgtuni.bookshop.domain.entities.Author;
import bg.sofgtuni.bookshop.domain.entities.Book;
import bg.sofgtuni.bookshop.domain.entities.Category;
import bg.sofgtuni.bookshop.domain.enums.AgeRestriction;
import bg.sofgtuni.bookshop.domain.enums.EditionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static bg.sofgtuni.bookshop.constants.FilePath.*;

//@Service
//public class SeedServiceImpl implements SeedService {
//
//    private final CategoryService categoryService;
//    private final AuthorService authorService;
//
//    private final BookService bookService;
//
//    @Autowired
//    public SeedServiceImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
//        this.categoryService = categoryService;
//        this.authorService = authorService;
//        this.bookService = bookService;
//    }
//
//    @Override
//    public void seedAuthors() throws IOException {
//        if(this.authorService.isDataSeeded()) return;
//
//        this.authorService.seedAuthors(
//                Files.readAllLines(Path.of(RESOURCE_URL + AUTHORS_FILE_NAME))
//                        .stream()
//                        .map(fullName -> Author.builder().firstName(fullName.split(" ")[0])
//                                .lastName(fullName.split(" ")[1]).build()).toList());
//    }
//
//    @Override
//    public void seedBooks() throws IOException {
//        if (this.bookService.isDataSeeded()) return;
//
//        final List<Book> books = Files.readAllLines(Path.of(RESOURCE_URL + BOOKS_FILE_NAME))
//                .stream()
//                .filter(s -> !s.isBlank())
//                .map(row -> {
//                    String[] args = row.split("\\s+");
//                    String title = Arrays.stream(args)
//                            .skip(5)
//                            .collect(Collectors.joining(" "));
//
//                    return Book.builder()
//                            .author(this.authorService.getRandomAuthor())
//                            .categories(this.categoryService.getRandomCategories())
//                            .title(title)
//                            .editionType(EditionType.values()[Integer.parseInt(args[0])])
//                            .ageRestriction(AgeRestriction.values()[Integer.parseInt(args[4])])
//                            .releaseDate(LocalDate.parse(args[1], DateTimeFormatter.ofPattern("d/M/yyyy")))
//                            .copies(Integer.parseInt(args[2]))
//                            .price(new BigDecimal(args[3]))
//                            .build();
//                }).toList();
//
//        this.bookService.seedBooks(books);
//    }
//
//    @Override
//    public void seedCategories() throws IOException {
//        if (this.categoryService.isDataSeeded()) return;
//
//        this.categoryService.seedCategories(
//        Files.readAllLines(Path.of(RESOURCE_URL + CATEGORY_FILE_NAME))
//                .stream()
//                .filter(s -> !s.isBlank())
//                .map(category -> Category.builder().name(category).build())
//                .toList());
//    }
//
//}


@Service
public class SeedServiceImpl implements SeedService {

    private final CategoryService categoryService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public SeedServiceImpl(CategoryService categoryService, BookService bookService, AuthorService authorService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorService.isDataSeeded()) return;

        this.authorService.seedAuthors(
                Files.readAllLines(Path.of(RESOURCE_URL + AUTHORS_FILE_NAME))
                        .stream()
                        .map(firstAndLastName -> Author.builder()
                                .firstName(firstAndLastName.split(" ")[0])
                                .lastName(firstAndLastName.split(" ")[1])
                                .build())
                        .toList());
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookService.isDataSeeded()) return;

        final List<Book> books = Files.readAllLines(Path.of(RESOURCE_URL + BOOKS_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(row -> {
                    String[] args = row.split("\\s+");
                    String title = Arrays.stream(args)
                            .skip(5)
                            .collect(Collectors.joining(" "));

                    return Book.builder()
                            .author(this.authorService.getRandomAuthor())
                            .categories(this.categoryService.getRandomCategories())
                            .title(title)
                            .editionType(EditionType.values()[Integer.parseInt(args[0])])
                            .ageRestriction(AgeRestriction.values()[Integer.parseInt(args[4])])
                            .releaseDate(LocalDate.parse(args[1], DateTimeFormatter.ofPattern("d/M/yyyy")))
                            .copies(Integer.parseInt(args[2]))
                            .price(new BigDecimal(args[3]))
                            .build();
                }).toList();

        this.bookService.seedBooks(books);
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryService.isDataSeeded()) return;

        this.categoryService.seedCategories(
                Files.readAllLines(Path.of(RESOURCE_URL + CATEGORY_FILE_NAME))
                        .stream()
                        .filter(s -> !s.isBlank())
                        .map(Category::new)
                        .toList());
    }

}