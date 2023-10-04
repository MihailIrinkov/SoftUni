package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "bank_account")
public class BankAccount extends BillingDetail{

    @Column(name = "bank_name", nullable = false, length = 60)
    private String bankName;

    @Column(name = "SWIFT_code", length = 50)
    private String swiftCode;
}
