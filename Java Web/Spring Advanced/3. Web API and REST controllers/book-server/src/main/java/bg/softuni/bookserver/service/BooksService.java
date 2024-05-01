package bg.softuni.bookserver.service;

import bg.softuni.bookserver.model.dto.BookDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface BooksService {

    List<BookDTO> getAllBooks();

    Optional<BookDTO> findBookById(Long id);

    void deleteBookById(Long id);

    Long createBook (BookDTO bookDTO);
}
