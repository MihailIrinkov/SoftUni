package PokemonTrainer_06;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Trainer> trainerList = new ArrayList<>();
        List<Pokemon> pokemonList = new ArrayList<>();

        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            int counter = 0;

            if (trainerList.size() > 0) {
                for (int i = 0; i < trainerList.size(); i++) {
                    Trainer current = trainerList.get(i);
                    String currentTrainerName = current.getName();

                    if (!currentTrainerName.equals(trainerName)) {
                        counter++;
                        pokemonList.add(pokemon);
                        Trainer trainer = new Trainer(trainerName, pokemonList);
                        trainerList.add(trainer);
                    } else {
                        for (int j = 0; j < trainerList.size(); j++) {
                            Trainer current1 = trainerList.get(j);
                            String currentTrainerName1 = current1.getName();
                            if (currentTrainerName1.equals(trainerName)) {
                                Trainer trainerUpdated = trainerList.get(j);
                                trainerUpdated.getPokemons().add(pokemon);
                                counter++;
                            }
                        }

                    }
                    if (counter > 0) {
                        break;
                    }
                }
            } else {
                pokemonList.add(pokemon);
                Trainer trainer = new Trainer(trainerName, pokemonList);
                trainerList.add(trainer);
            }
            pokemonList.clear();

            input = scanner.nextLine();
        }


        String element = scanner.nextLine();

        while (!element.equals("End")) {
            switch (element) {
                case "Fire":

                    for (int i = 0; i < trainerList.size(); i++) {
                        Trainer currentTr = trainerList.get(i);
                        pokemonHasElement(currentTr, element);
                    }
                    break;

                case "Water":
                    for (int i = 0; i < trainerList.size(); i++) {
                        Trainer currentTr = trainerList.get(i);
                        pokemonHasElement(currentTr, element);
                    }
                    break;

                case "Electricity":
                    for (int i = 0; i < trainerList.size(); i++) {
                        Trainer currentTr = trainerList.get(i);
                        pokemonHasElement(currentTr, element);
                    }
                    break;
            }

            element = scanner.nextLine();
        }

        trainerList.sort((a, b) -> Integer.compare(b.getNumberOfBadges(), a.getNumberOfBadges()));

        for (Trainer t : trainerList) {
            System.out.println(t.getName() + " " + t.getNumberOfBadges() + " " + t.getPokemons().size());
        }

    }

    private static void pokemonHasElement(Trainer currentTr, String element) {
        for (int j = 0; j < currentTr.getPokemons().size(); j++) {

            Pokemon currentPokemon = currentTr.getPokemons().get(j);
            if (currentPokemon.getElement().equals(element)) {
                int currentB = currentTr.getNumberOfBadges() + 1;
                currentTr.setNumberOfBadges(currentB);
                break;
            } else {
                for (int k = 0; k < currentTr.getPokemons().size(); k++) {
                    Pokemon currentPokemonH = currentTr.getPokemons().get(j);
                    int currentPokemonHealth = currentPokemonH.getHealth();
                    if ((currentPokemonHealth - 10) > 0) {
                        int newHealth = currentPokemonHealth - 10;
                        currentPokemonH.setHealth(newHealth);
                    } else {
                        currentTr.getPokemons().remove(currentPokemonH);
                    }
                }
            }
        }
    }
}
