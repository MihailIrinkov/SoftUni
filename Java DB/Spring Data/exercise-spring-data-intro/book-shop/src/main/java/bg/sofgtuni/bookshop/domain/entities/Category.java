package bg.sofgtuni.bookshop.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@Table(name = "categories")
//public class Category extends BaseEntity {
//
//    @Column(nullable = false)
//    private String name;
//
////    @ManyToMany
////    private Set<Book> books;
//}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(nullable = false)
    private String name;

}
