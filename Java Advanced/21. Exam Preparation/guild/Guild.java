package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }


    public void addPlayer(Player player) {
        if (capacity > roster.size()) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player p : roster) {
            if (p.getName().equals(name)) {
                roster.remove(p);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player p : roster) {
            if (p.getName().equals(name)) {
                p.setRank("Member");
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player p : roster) {
            if (p.getName().equals(name)) {
                p.setRank("Trial");
            }
        }
    }


    public Player[] kickPlayersByClass(String clazz) {
        List<String> current = new ArrayList<>();
        for (Player p : roster) {
            if (p.getClazz().equals(clazz)) {
                current.add(p.getName());
            }
        }
        int size = current.size();

        Player[] kickedPlayers = new Player[current.size()];

        for (int i = 0; i < size; i++) {
            for (Player p : roster) {
                if (p.getName().equals(current.get(i))) {
                    kickedPlayers[i] = p;
                }
            }
        }

        List<Player> pToRemove = new ArrayList<>();

        for (int i = 0; i < kickedPlayers.length; i++) {

            for (Player p : roster) {
                if (kickedPlayers[i].getName().equals(p.getName())) {
                    pToRemove.add(p);
                }
            }
        }

        for (int i = 0; i < pToRemove.size(); i++) {
            roster.remove(pToRemove.get(i));
        }

        return kickedPlayers;
    }

    public int count () {
        return this.roster.size();
    }

    public String report() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Players in the guild: %s:", this.name));
        sb.append("\n");
        for (Player p : roster) {
            sb.append(p);
            sb.append("\n");
        }

        return sb.toString().trim();
    }
}
