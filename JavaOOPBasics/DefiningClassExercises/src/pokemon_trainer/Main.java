package pokemon_trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Trainer> trainers = new LinkedList<>();

        addTrainers(trainers, reader);
        pokemonElementAction(trainers, reader);

        trainers.stream().sorted((x, y) -> Integer.compare(y.getBadges(), x.getBadges())).forEach(e-> {
            System.out.println(e.getName() + " " + e.getBadges() + " " + e.getPokemons().size());
        });


    }

    private static void pokemonElementAction(List<Trainer> trainers, BufferedReader reader) throws IOException {
        while(true){
            String command = reader.readLine();
            if("End".equals(command)){
                break;
            }
            pokemonElementResult(trainers, command);
        }
    }

    private static void pokemonElementResult(List<Trainer> trainers, String command) {
        for (Trainer trainer: trainers) {
            boolean isBadgeAdded = false;
            for (Pokemon pokemon:trainer.getPokemons()) {
                if (command.equals(pokemon.getElement())){
                    trainer.setBadges(trainer.getBadges()+1);
                    isBadgeAdded = true;
                    break;
                }
            }
            adjustPokemonHealth(isBadgeAdded, trainer);
        }
    }

    private static void adjustPokemonHealth(boolean isBadgeAdded, Trainer trainer) {
        if (!isBadgeAdded){
            for (Pokemon pokemon : trainer.getPokemons()) {
                int pokemonHealth = pokemon.getHealth() -10;
                if (pokemonHealth <1){
                    trainer.deletePokemons(pokemon);
                } else {
                    pokemon.setHealth(pokemonHealth);
                }
            }
        }
    }

    private static void addTrainers(List<Trainer> trainers, BufferedReader reader) throws IOException {
        while(true){
            String[] commands = reader.readLine().split("\\s++");
            String trainerName = commands[0];
            if ("Tournament".equals(trainerName)){
                break;
            }
            String pokemonName = commands[1];
            String pokemonElement = commands[2];
            int pokemonHealth = Integer.valueOf(commands[3]);

            Pokemon newPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            boolean isTrainer = false;
            for (Trainer trainer:trainers) {
                if (trainer.getName().equals(trainerName)){
                    trainer.setPokemons(newPokemon);
                    isTrainer = true;
                    break;
                }
            }
            if (!isTrainer){
                List<Pokemon> trainerPokemons = new ArrayList<>();
                trainerPokemons.add(newPokemon);
                Trainer newTrainer = new Trainer(trainerName, trainerPokemons);
                trainers.add(newTrainer);
            }
        }
    }

}
