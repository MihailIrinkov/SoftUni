package entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle{

    public Bike() {
    }

    public Bike(String type, String model, BigDecimal price) {
        super(type, model, price);
    }
}
