package football_team_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Team> teams = new LinkedList<>();

            while(true) {
                    String[] info = reader.readLine().split(";");
                    if ("END".equals(info[0])) {
                        break;

                    }
                try {
                    if ("team".equalsIgnoreCase(info[0])) {
                        Team newTeam = new Team();
                        newTeam.setName(info[1]);
                        teams.add(newTeam);
                    } else {
                        boolean isError = true;
                        for (Team team : teams) {
                            if (team.getName().equalsIgnoreCase(info[1]) && "rating".equalsIgnoreCase(info[0])) {
                                System.out.println(team);
                                isError = false;
                                break;
                            } else if (team.getName().equals(info[1])) {
                                if ("add".equalsIgnoreCase(info[0])) {
                                    Player newPlayer = new Player(info[2]);
                                    newPlayer.addSkills(info);
                                    team.addPlayers(newPlayer);
                                } else if ("remove".equalsIgnoreCase(info[0])) {
                                    team.removePlayer(info[2]);
                                }
                                isError = false;
                                break;
                            }
                        }
                        if (isError) {
                            throw new IllegalArgumentException(String.format("Team %s does not exist.", info[1]));
                        }
                    }
                } catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                }
            }
    }
}
