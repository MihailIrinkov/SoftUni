package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseField implements Field{
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSupplements(Collection<Supplement> supplements) {
        this.supplements = supplements;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    public int sumEnergy() {
        int sum = supplements.stream().mapToInt(Supplement::getEnergy).sum();
        return sum;
    }

    public void addPlayer (Player player) {
        if (capacity == players.size()) {
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
        players.add(player);
    }

    public void removePlayer (Player player) {
        players.remove(player);
    }

    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

   public void drag() {
       for (Player p : players) {
           p.stimulation();
       }
   }

   public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", this.name, getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append("Player: ");
        if(players.isEmpty()) {
            sb.append("none");
        } else {
//       for (Player p : players) {
//           sb.append(p.getName());
//       }
            sb.append(players.stream().map(Player::getName).collect(Collectors.joining(" ")).trim());
        }
       sb.append(System.lineSeparator());
       sb.append(String.format("Supplement: %d", supplements.size()));
       sb.append(System.lineSeparator());
       sb.append(String.format("Energy: %d", sumEnergy()));
       return sb.toString().trim();
   }


    @Override
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }
}
