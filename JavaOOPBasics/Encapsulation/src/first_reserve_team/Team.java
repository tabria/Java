package first_reserve_team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Team {

    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        setName(name);
        firstTeam = new ArrayList<>();
        reserveTeam = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }


    private void setFirstTeam(Person person) {
        this.firstTeam.add(person);
    }

    private void setReserveTeam(Person person) {
        this.reserveTeam.add(person);
    }

    public void addPlayer(Person person){
        if (person.getAge() < 40){
            setFirstTeam(person);
        } else {
            setReserveTeam(person);
        }
    }
}
