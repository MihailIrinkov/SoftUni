package entities;


import entities.enums.ResultPredictionValue;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "result_prediction")
public class ResultPrediction extends BaseEntity{

    @Enumerated(EnumType.STRING)
    ResultPredictionValue resultPrediction;
}
