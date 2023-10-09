package entities;

import javax.persistence.*;

public class BetGame {

    @Id
    @OneToOne
    private Game game;

    @Id
    @OneToOne
    private Bet bet;

    @OneToOne
    @JoinColumn
    private ResultPrediction resultPrediction;
}
