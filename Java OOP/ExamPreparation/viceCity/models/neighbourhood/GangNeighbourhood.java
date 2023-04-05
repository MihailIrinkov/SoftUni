package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;

public class GangNeighbourhood implements Neighbourhood {
//    private Player mainPlayer;
//    private Collection<Player> civilPlayers;
//    private Collection<Gun> gunCollection;


    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Repository<Gun> tomiGunRepo = mainPlayer.getGunRepository();
        Deque<Gun> tomiGuns = new ArrayDeque<>(tomiGunRepo.getModels());
        Deque<Player> playersQu = new ArrayDeque<>(civilPlayers);

        Player currentPlayer = playersQu.poll();
        Gun currentGun = tomiGuns.poll();

        while (currentPlayer != null && currentGun != null) {

//            if (currentGun.canFire()) {
//
//                if (currentPlayer.isAlive()) {
//                    currentPlayer.takeLifePoints(currentGun.fire());
//                } else {
//                    currentPlayer = playersQu.pop();
//                }
//            } else {
//                currentGun = gunsQu.pop();
//            }

            while (currentGun.canFire() && currentPlayer.isAlive()) {
                int shot = currentGun.fire();
                currentPlayer.takeLifePoints(shot);
            }
            if(currentGun.canFire()) {
                currentPlayer = playersQu.poll();
            } else {
               currentGun =  tomiGuns.poll();
            }
        }

//        Deque<Gun> playersGuns = new ArrayDeque<>(currentPlayer.getGunRepository().getModels());
//        Gun currentPlayerGun = playersGuns.pop();

//        while (mainPlayer.isAlive()) {
//
//            while (currentPlayerGun.canFire()) {
//                mainPlayer.takeLifePoints(currentPlayerGun.fire());
//            }
//
//            if (!currentPlayerGun.canFire() && !playersGuns.isEmpty()) {
//                currentPlayerGun = playersGuns.pop();
//            } else {
//                currentPlayer = playersQu.pop();
//            }
//
//        }

        for (Player civilPlayer: civilPlayers) {
            if (civilPlayer.isAlive()) {
                Repository<Gun> civilPlayerRepo = civilPlayer.getGunRepository();
                Deque<Gun> civilPlayerGuns = new ArrayDeque<>(civilPlayerRepo.getModels());
                Gun civilPlayerGun = civilPlayerGuns.poll();

                while (civilPlayerGun != null) {
                    while (civilPlayerGun.canFire() && mainPlayer.isAlive()) {
                        int shot = civilPlayerGun.fire();
                        mainPlayer.takeLifePoints(shot);
                    }
                    if (!mainPlayer.isAlive()) {
                        return;
                    }
                    civilPlayerGuns.poll();
                }
            }
        }

    }


}
