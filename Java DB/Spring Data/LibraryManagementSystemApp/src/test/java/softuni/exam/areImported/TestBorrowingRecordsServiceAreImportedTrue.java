//package softuni.exam.areImported;
////TestBorrowingRecordsServiceAreImportedTrue
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import softuni.exam.repository.BorrowingRecordRepository;
//import softuni.exam.service.impl.BorrowingRecordsServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//public class TestBorrowingRecordsServiceAreImportedTrue {
//
//    @InjectMocks
//    private BorrowingRecordsServiceImpl borrowingRecordsService;
//    @Mock
//    private BorrowingRecordRepository mockBorrowingRecordRepository;
//
//    @Test
//    void areImportedShouldReturnTrue() {
//        Mockito.when(mockBorrowingRecordRepository.count()).thenReturn(1L);
//        Assertions.assertTrue(borrowingRecordsService.areImported());
//    }
//}