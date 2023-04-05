package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Map<String, Player> civilPlayers;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        CivilPlayer player = new CivilPlayer(name);
        civilPlayers.put(name, player);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                this.guns.offer(gun);
                break;
            case "Rifle":
                gun = new Rifle(name);
                this.guns.offer(gun);
                break;
            default:
                return String.format(ConstantMessages.GUN_TYPE_INVALID);

        }
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gunToAdd = guns.poll();

        if (gunToAdd == null) {
            return String.format(ConstantMessages.GUN_QUEUE_IS_EMPTY);
        }

        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gunToAdd);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER,
                    gunToAdd.getName(), mainPlayer.getName());
        }

        Player civilPlayer = civilPlayers.get(name);

        if (civilPlayer == null) {
            return String.format(ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST);
        }

//        if (!civilPlayers.containsKey(name)) {
//            return String.format(ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST);
//        }


//        civilPlayers.get(name).getGunRepository().add(gunToAdd);
        civilPlayer.getGunRepository().add(gunToAdd);
        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER,
                gunToAdd.getName(), name);
    }

    @Override
    public String fight() {
        neighbourhood.action(mainPlayer, civilPlayers.values());
//        boolean allPlayersAlive = true;
//
//        for (Player p : civilPlayers.values()) {
//            if (p.getLifePoints() < 50) {
//                allPlayersAlive = false;
//            }
//        }

        if (mainPlayer.getLifePoints() == 100
                && civilPlayers.values().stream().allMatch(p -> p.getLifePoints() == 50)) {
            return String.format(ConstantMessages.FIGHT_HOT_HAPPENED);
        }

        StringBuilder sb = new StringBuilder();

        //List<Player> deadPlayers = new ArrayList<>();

//        for (Player p : civilPlayers.values()) {
//            if (!p.isAlive()) {
//                deadPlayers.add(p);
//            }
//        }

        List<Player> deadPlayers = civilPlayers.values().stream()
                .filter(p -> !p.isAlive()).collect(Collectors.toList());

        sb.append(String.format(ConstantMessages.FIGHT_HAPPENED));
        sb.append(System.lineSeparator());
        sb.append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE
                , mainPlayer.getLifePoints()));
        sb.append(System.lineSeparator());
        sb.append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE
                , deadPlayers.size()));
        sb.append(System.lineSeparator());
        sb.append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE
                , civilPlayers.size() - deadPlayers.size()));

        return sb.toString();
    }
}
