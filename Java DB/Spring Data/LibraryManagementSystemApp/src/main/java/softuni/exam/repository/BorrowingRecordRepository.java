package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.dto.BorrowingRecordDTO;
import softuni.exam.models.entity.BorrowingRecord;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// TODO:
@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {

    List<BorrowingRecord> findByBorrowDateBeforeOrderByBorrowDateDesc(LocalDate borrowingDate);

    BorrowingRecord findByBookId(Long id);
}
