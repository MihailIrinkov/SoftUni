package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "borrowing_record")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordDTO {

    @NotNull
    @XmlElement(name = "borrow_date")
    private String borrowDate;
    @NotNull
    @XmlElement(name = "return_date")
    private String returnDate;
    @XmlElement(name = "book")
    @NotNull
    private XmlBookImportDTO title;

    @XmlElement(name = "member")
    @NotNull
    private XmlLibraryMemberDTO member;
    @XmlElement(name = "remarks")
    @Size(min = 3, max = 100)
    private String remarks;

    public BorrowingRecordDTO() {
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public XmlBookImportDTO getTitle() {
        return title;
    }

    public void setTitle(XmlBookImportDTO title) {
        this.title = title;
    }

    public XmlLibraryMemberDTO getMember() {
        return member;
    }

    public void setMember(XmlLibraryMemberDTO member) {
        this.member = member;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
