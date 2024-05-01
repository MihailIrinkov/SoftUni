package bg.softuni.bookserver.web;

import bg.softuni.bookserver.model.dto.BookDTO;
import bg.softuni.bookserver.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/books")
public class BooksRestController {

    private final BooksService booksService;

    public BooksRestController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {

        return ResponseEntity.ok(booksService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable("id") Long id) {
        Optional<BookDTO> bookDTOOptional = booksService.findBookById(id);

//        if (bookDTOOptional.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(bookDTOOptional.get());
//        }

        return bookDTOOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteBookById(@PathVariable("id") Long id) {
        booksService.deleteBookById(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(
            @RequestBody
            BookDTO bookDTO,
            UriComponentsBuilder uriComponentsBuilder) {

        long newBookId = booksService.createBook(bookDTO);
        System.out.println(bookDTO);

        return ResponseEntity.created(
                        uriComponentsBuilder.path("/api/books/{id}")
                                .build(newBookId))
                .build();

    }
}
