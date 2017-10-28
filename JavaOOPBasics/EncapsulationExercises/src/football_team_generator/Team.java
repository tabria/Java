package football_team_generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private static final double DEFAULT_RATING = 0.0;
    private static final String DEFAULT_NAME_VALUE = "";

    private String name;
    private List<Player> players;


    public Team() {
        this.name = DEFAULT_NAME_VALUE;
        this.players = new ArrayList<>();
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        if (name.isEmpty() || name.length()<=0 || name.matches("\\s+")){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private double calculateRating() {
        double allRatings =DEFAULT_RATING;
        for (Player player: this.players) {
            allRatings +=player.playerOverallSkill();
        }
        this.players.size();
        return allRatings/this.players.size();
    }

     private List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

     void addPlayers(Player player) {
        this.players.add(player);
    }

     void removePlayer(String playerName){
        for (Player player: getPlayers()) {
            if (player.getName().equalsIgnoreCase(playerName)){
                this.players.remove(player);
                return;
            }
        }
        throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
    }

    @Override
    public String toString() {
        return name + " - " + Math.round(calculateRating());
    }
}
