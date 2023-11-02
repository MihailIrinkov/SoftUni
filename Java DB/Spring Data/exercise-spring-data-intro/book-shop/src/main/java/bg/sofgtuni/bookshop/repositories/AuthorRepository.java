package bg.sofgtuni.bookshop.repositories;

import bg.sofgtuni.bookshop.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public interface AuthorRepository extends JpaRepository<Author, Long> {
//
//    @Query("SELECT a FROM Author a ORDER BY a.books.size")
//    Optional<List<Author>> findAllDistinctOrderByBooksSize();
//}

// creating the repository interface will create table in the database
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("Select a from Author a order by size(a.books)")
    List<Author> findAllDistinctOrderByBooks();

    List<Author> findAllByFirstNameEndingWith(String suffix);

    List<Author> findAll();
}


