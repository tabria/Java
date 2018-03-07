package avatar;


import avatar.entities.benders.Bender;
import avatar.entities.monuments.Monument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Nation {

    private List<Bender> benders;
    private List<Monument> monuments;

    public Nation() {
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
    }


    List<Bender> getBenders() {
        return Collections.unmodifiableList(this.benders);
    }

    List<Monument> getMonuments() {
        return Collections.unmodifiableList(this.monuments);
    }

    void addBender(Bender bender) {
        this.benders.add(bender);
    }

    void addMonument(Monument monument) {
        this.monuments.add(monument);
    }

    void clearNation(){
        this.benders.clear();
        this.monuments.clear();
    }
}
