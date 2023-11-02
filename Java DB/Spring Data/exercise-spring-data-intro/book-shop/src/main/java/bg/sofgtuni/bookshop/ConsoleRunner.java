package bg.sofgtuni.bookshop;

import bg.sofgtuni.bookshop.service.AuthorService;
import bg.sofgtuni.bookshop.service.BookService;
import bg.sofgtuni.bookshop.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;
    private final Scanner scanner;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAllData();
        //this.bookService.getAllBooksAfterYear(LocalDate.of( 2000, 1, 1));

//        this.authorService
//                .getAllAuthorsWithBooksBeforeGivenYear(LocalDate.of(1991, 1, 1));

//        this.authorService.getAllAuthorsWithBooksBeforeYear(LocalDate.of(1991, 1, 1));
//
//        this.authorService.getAllAuthorsOrderByBooksDesc();

//        String[] input = this.scanner.nextLine().split("-");
//        String suffix = input[0];
//        String day = input[0];
//        String month = input[1];
//        String year = input[2];
//
//        bookService
//                .getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(
//                  firstName, lastName
//                );


        // ** 14. Exercise: Spring Data Advanced Querying

        // 1.	Books Titles by Age Restriction
//        String[] input = this.scanner.nextLine().split(" ");
//        String ageRestriction = input[0];
//
//        this.bookService.getAllByAgeRestriction(ageRestriction);

        // 2.	Golden Books
//        this.bookService.findAllByEditionTypeAndCopiesLessThen("GOLD", 5000);


        // 3.	Books by Price
//        this.bookService.findAllByPriceLessOrGreater(BigDecimal.valueOf(5), BigDecimal.valueOf(40));

        // 4.	Not Released Books
//        this.bookService
//                .getAllByReleaseDateAfterAndReleaseDateBefore(LocalDate.of(1998, 12, 31),
//                        LocalDate.of(1998, 01, 01));

        // 5.	Books Released Before Date
//        this.bookService.findAllByReleaseDateBefore(LocalDate.of(
//                Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)
//        ));

        // 6.	Authors Search
//        this.authorService.getAllByFirstNameEndingWith(suffix);

        // 7.	Books Search
//        this.bookService.getAllByTitleContaining("WOR");

        // 8.	Book Titles Search
//        this.bookService.getAllByAuthorLastNameStartingWith("gr");


        // 9.	Count Books
//        this.bookService.getAllByTitleLengthLongerThan(40);


        //("Randy", "Graham");


//        this.authorService.getAll();

        // 11.	Reduced Book
//        this.bookService.getAllByTitle("Things Fall Apart");

        // 12.	* Increase Book Copies
//        this.bookService
//                .increaseCopiesAfterGivenYear(100, LocalDate.of(2005, 10, 12));


        // 13.	* Remove Books
//        this.bookService.deleteAllByCopiesLessThan(10000);


//        this.bookService.findBooksByAuthorFirstNameAndAuthorLastname("Amanda Rice");

        // 10.	Total Book Copies
//        this.authorService.getAll();

//
//        System.out.println("Do you want to test tasks?[YES/NO]");
//        String input = scanner.nextLine().toUpperCase();
//
//        while (input.equals("YES")) {
//
//            System.out.println("Enter the number of task[1-14]");
//
//            input = scanner.nextLine();
//
//            switch(input) {
//                case "1":
//
//                    break;
//
//                case "2":
//
//                    break;
//
//                case "3":
//
//                    break;
//
//                case "4":
//
//                    break;
//
//                case "5":
//
//                    break;
//
//                case "6":
//
//                    break;
//
//                case "7":
//
//                    break;
//
//                case "8":
//
//                    break;
//
//                case "9":
//
//                    break;
//
//                case "10":
//
//                    break;
//
//                case "11":
//
//                    break;
//
//                case "12":
//
//                    break;
//
//                case "13":
//
//                    break;
//
//                case "14":
//
//                    break;
//            }
//
//
//            System.out.println("Are you gone test more tasks?[YES/NO]");
//            input = scanner.nextLine();
//        }
//
//        System.out.println("Have a nice day");
    }
}
