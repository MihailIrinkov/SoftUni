package com.ownproject.BreakApp.model.entity;

import com.ownproject.BreakApp.model.enums.AvailabilityStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "availability")
public class Availability extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AvailabilityStatus availabilityStatus;

    public Availability() {
    }

    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public Availability setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
        return this;
    }
}
