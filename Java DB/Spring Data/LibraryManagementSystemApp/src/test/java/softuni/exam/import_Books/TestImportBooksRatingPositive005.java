//package softuni.exam.import_Books;
////TestImportBooksRatingPositive005
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import softuni.exam.service.impl.BookServiceImpl;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
//public class TestImportBooksRatingPositive005 {
//
//    @Autowired
//    private BookServiceImpl bookService;
//
//    @Test
//    void testImportBooksRatingPositive005() throws IOException {
//
//        String expected = "Successfully imported book J.R.R. Tolkien - The Lord of the Rings\n" +
//                "Invalid book\n" +
//                "Invalid book";
//        String[] expectedSplit = expected.split("\\r\\n?|\\n");
//
//        copyRewriteFileForTest();
//
//        try {
//            String actual = bookService.importBooks();
//            String[] actualSplit = actual.split("\\r\\n?|\\n");
//            Assertions.assertArrayEquals(expectedSplit, actualSplit);
//        } finally {
//            returnOriginalValue();
//        }
//    }
//
//    private void copyRewriteFileForTest() throws IOException {
//        File originalJsonFile = new File("src/main/resources/files/json/books.json");
//
//        String testJSON = "[\n" +
//                "\n" +
//                "  {\n" +
//                "    \"author\": \"J.R.R. Tolkien\",\n" +
//                "    \"available\": false,\n" +
//                "    \"description\": \"An epic fantasy trilogy\",\n" +
//                "    \"genre\": \"SCIENCE_FICTION\",\n" +
//                "    \"title\": \"The Lord of the Rings\",\n" +
//                "    \"rating\": 5.2\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"author\": \"Aldous Huxley\",\n" +
//                "    \"available\": true,\n" +
//                "    \"description\": \"A dystopian novel envisioning a future society\",\n" +
//                "    \"genre\": \"SCIENCE_FICTION\",\n" +
//                "    \"title\": \"Brave New World\",\n" +
//                "    \"rating\": 0\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"author\": \"C.S. Lewis\",\n" +
//                "    \"available\": true,\n" +
//                "    \"description\": \"A series of fantasy novels about Narnia\",\n" +
//                "    \"genre\": \"FANTASY\",\n" +
//                "    \"title\": \"The Chronicles of Narnia\",\n" +
//                "    \"rating\": -5.6\n" +
//                "  }\n" +
//                "]\n";
//
//        try {
//            FileWriter f2 = new FileWriter(originalJsonFile, false);
//            f2.write(testJSON);
//            f2.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void returnOriginalValue() {
//        File originalJsonFileSrc = new File("src/main/resources/files/json/books.json");
//
//        try {
//            FileWriter f2 = new FileWriter(originalJsonFileSrc, false);
//            String testOriginalFile = Files.readString(Path.of("src/test/resources/original-files/books.json"));
//            f2.write(testOriginalFile);
//            f2.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
