package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookImportDTO;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtilsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// TODO: Implement all methods
@Service
public class BookServiceImpl implements BookService {

    private static String BOOK_FILE_PATH = "src/main/resources/files/json/books.json";
    private final BookRepository bookRepository;
    private final Gson gson;
    private final ValidationUtilsImpl validationUtils;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, Gson gson, ValidationUtilsImpl validationUtils, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean areImported() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return Files.readString(Path.of(BOOK_FILE_PATH));
    }

    @Override
    public String importBooks() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<BookImportDTO> booksList = Arrays.stream(gson.fromJson(readBooksFromFile(), BookImportDTO[].class))
                .collect(Collectors.toList());

        for (BookImportDTO b : booksList) {
            Optional<Book> book = this.bookRepository.findByTitle(b.getTitle());

            if (book.isEmpty() && validationUtils.isValid(b)) {

                Book bookToSave = modelMapper.map(b, Book.class);
                this.bookRepository.save(bookToSave);

                sb.append(String.format("Successfully imported book %s - %s%n",
                        bookToSave.getAuthor(), bookToSave.getTitle()));
            } else {
                sb.append("Invalid book");
                sb.append(System.lineSeparator());
            }

        }
        return sb.toString().trim();
    }
}
