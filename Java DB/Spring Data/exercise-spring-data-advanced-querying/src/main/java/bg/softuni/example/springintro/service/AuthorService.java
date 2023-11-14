package bg.softuni.example.springintro.service;

import bg.softuni.example.springintro.model.entity.Author;


import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();
}
