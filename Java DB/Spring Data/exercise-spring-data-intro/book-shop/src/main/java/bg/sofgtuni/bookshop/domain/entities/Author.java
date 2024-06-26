package bg.sofgtuni.bookshop.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author", fetch = FetchType.EAGER)
    public List<Book> books;

    public String getAuthorFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getAuthorFullNameAndCountOfBooks() {
        return this.firstName + " " + this.lastName + " " + this.books.size();
    }

    // System.out.println(bookList.stream().mapToInt(b -> b.getCopies()).sum());
    public String getAuthorFullNameAndCountOfBooksCopies() {
        return this.firstName + " " + this.lastName + " - " + this.books.stream()
                .mapToInt(b -> b.getCopies()).sum();
    }

    public int getAllCopies() {
        return this.books.stream()
                .mapToInt(b -> b.getCopies()).sum();
    }
}
