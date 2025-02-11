package com.ownproject.BreakApp.model.entity;

import com.ownproject.BreakApp.model.enums.ChanelType;
import jakarta.persistence.*;

@Entity
@Table(name = "chanels")
public class Chanel extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChanelType chanelType;

    public Chanel() {
    }

    public Chanel(ChanelType chanelType) {
        this.chanelType = chanelType;
    }

    public ChanelType getChanelType() {
        return chanelType;
    }

    public Chanel setChanelType(ChanelType chanelType) {
        this.chanelType = chanelType;
        return this;
    }
}
