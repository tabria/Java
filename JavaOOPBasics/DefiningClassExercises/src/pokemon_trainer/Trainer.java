package pokemon_trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private final static int DEFAULT_BADGES = 0;

    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.badges = DEFAULT_BADGES;
        this.pokemons = pokemons;
    }

    public String getName() {
        return this.name;
    }

    public void setPokemons(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void deletePokemons(Pokemon pokemon) {
        this.pokemons.remove(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return new ArrayList<>(this.pokemons);
    }


    public void setBadges(int badges) {
        this.badges = badges;
    }

    public int getBadges() {
        return this.badges;
    }


}
