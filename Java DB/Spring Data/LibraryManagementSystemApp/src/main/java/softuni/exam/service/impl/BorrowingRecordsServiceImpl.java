package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.config.XmlParser;
import softuni.exam.models.dto.BorrowingRecordDTO;
import softuni.exam.models.dto.BorrowingRecordRootDTO;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.BookRepository;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.util.ValidationUtilsImpl;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO: Implement all methods
@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

    private static String BORROWING_RECORD_PATH = "src/main/resources/files/xml/borrowing-records.xml";
    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final LibraryMemberRepository libraryMemberRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtilsImpl validationUtils;

    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository, BookRepository bookRepository, LibraryMemberRepository libraryMemberRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtilsImpl validationUtils) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.libraryMemberRepository = libraryMemberRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of(BORROWING_RECORD_PATH));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<BorrowingRecordDTO> recordsList =
                new ArrayList<>(xmlParser.fromFile(Path.of(BORROWING_RECORD_PATH).toFile(),
                        BorrowingRecordRootDTO.class).getRecordsDTO());

        for (BorrowingRecordDTO record : recordsList) {
            boolean isValid = validationUtils.isValid(record);
            Optional<Book> book = this.bookRepository.findByTitle(record.getTitle().getTitle());
            if (book.isEmpty() || !isValid) {
                sb.append("Invalid borrowing record");
                sb.append(System.lineSeparator());
                continue;
            }

            Optional<LibraryMember> member =
                    this.libraryMemberRepository.findById(record.getMember().getId());
            if (member.isEmpty()) {
                sb.append("Invalid borrowing record");
                sb.append(System.lineSeparator());
                continue;
            }

            if (isValid) {
                BorrowingRecord recordToSave = modelMapper.map(record, BorrowingRecord.class);

                recordToSave.setMember(member.get());

                recordToSave.setBook(book.get());
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                String borrowDateString = record.getBorrowDate();
//                LocalDate borrowLocalDate = LocalDate.parse(borrowDateString, formatter);
//                recordToSave.setBorrowDate(borrowLocalDate);
//
//                String returnDateString = record.getReturnDate();
//                LocalDate returnLocalDate = LocalDate.parse(returnDateString, formatter);
//                recordToSave.setReturnDate(returnLocalDate);

                this.borrowingRecordRepository.save(recordToSave);
                String formattedDate = recordToSave.getBorrowDate()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                sb.append(String.format("Successfully imported borrowing record %s - %s%n"
                        , recordToSave.getBook().getTitle(), formattedDate));
            }
        }


//        xmlParser
//                .fromFile(Path.of(BORROWING_RECORD_PATH).toFile(), BorrowingRecordRootDTO.class)
//                .getRecordsDTO()
//                .stream()
//                .filter(borrowingRecordSeedDto -> {
//                    boolean isValid = validationUtils.isValid(borrowingRecordSeedDto);
//
//                    LibraryMember libraryMember = this.libraryMemberRepository.findById(borrowingRecordSeedDto.getMember().getId()).orElse(null);
//                    if (libraryMember == null) {
//                        isValid = false;
//                    }
//
//                    Book bookByTitle = bookRepository.findByTitle(borrowingRecordSeedDto.getTitle().getTitle()).orElse(null);
//
//                    if (bookByTitle == null) {
//                        isValid = false;
//                    }
//
//                    sb.append(isValid
//                                    ? String.format("Successfully imported borrowing record %s - %s",
//                                    borrowingRecordSeedDto.getTitle().getTitle(),
//                                    borrowingRecordSeedDto.getBorrowDate())
//                                    : "Invalid borrowing record")
//                            .append(System.lineSeparator());
//
//                    return isValid;
//                })
//                .map(borrowingRecordDto -> {
//                    BorrowingRecord borrowingRecord = modelMapper.map(borrowingRecordDto, BorrowingRecord.class);
//
//                    LibraryMember libraryMember = libraryMemberRepository.findById(borrowingRecordDto.getMember().getId()).get();
//                    Book bookByTitle = bookRepository.findByTitle(borrowingRecordDto.getTitle().getTitle()).get();
//
//                    borrowingRecord.setBook(bookByTitle);
//                    borrowingRecord.setMember(libraryMember);
//
//                    return borrowingRecord;
//                })
//                .forEach(borrowingRecordRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportBorrowingRecords() {
        StringBuilder sb = new StringBuilder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String borrowDateString = "2021-09-10";
        LocalDate borrowLocalDate = LocalDate.parse(borrowDateString, formatter);

        List<BorrowingRecord> booksList =
                this.borrowingRecordRepository
                        .findByBorrowDateBeforeOrderByBorrowDateDesc(borrowLocalDate);

        List<BorrowingRecord> booksToPrint = new ArrayList<>();

        for (BorrowingRecord record : booksList) {
            Long bookId = this.bookRepository.findById(record.getBook().getId()).get().getId();
            Book book = this.bookRepository.findById(bookId).get();
            if (book.getGenre().toString().equals("SCIENCE_FICTION")) {

                booksToPrint.add(record);
            }
        }

        for (BorrowingRecord b : booksToPrint) {
            Long bookId = this.bookRepository.findById(b.getBook().getId()).get().getId();
            String bootTitle = this.bookRepository.findById(bookId).get().getTitle();
            String author = this.bookRepository.findById(bookId).get().getAuthor();
            String dateBorrowed =
                    this.borrowingRecordRepository.findById(b.getId()).get().getBorrowDate().toString();
            LibraryMember member =
                    this.libraryMemberRepository.findById(b.getMember().getId()).get();

            sb.append(String.format("Book title: %s%n" +
                            "*Book author: %s%n" +
                            "**Date borrowed: %s%n" +
                            "***Borrowed by: %s%n",
                    bootTitle, author, dateBorrowed, member.getFullName()));
        }

        return sb.toString().trim();
    }
}
