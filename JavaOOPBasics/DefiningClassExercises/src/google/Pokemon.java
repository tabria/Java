package google;

import java.util.Arrays;

public class Pokemon {

    private final static String DEFAULT_VALUE = "";

    private String pokemonName;
    private String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    public String getPokemonName() {
        return this.pokemonName;
    }

    public void setPokemonType(String pokemonType) {
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {

        return pokemonName + " " + pokemonType;
    }
}
