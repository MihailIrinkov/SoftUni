package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "borrowing_records")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordRootDTO {

    @XmlElement(name = "borrowing_record")
    private List<BorrowingRecordDTO> recordsDTO;

    public BorrowingRecordRootDTO() {
    }

    public List<BorrowingRecordDTO> getRecordsDTO() {
        return recordsDTO;
    }

    public void setRecordsDTO(List<BorrowingRecordDTO> recordsDTO) {
        this.recordsDTO = recordsDTO;
    }
}
