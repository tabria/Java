package military_elite.entities;

import java.util.Collections;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {

    private List<Mission> missions;

    public Commando(String id, String name, String lastName, double salary, String corp, List<Mission> missions) {
        super(id, name, lastName, salary, corp);
        this.missions = missions;
    }

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%sMissions:%n",super.toString()));
        this.getMissions().forEach(m-> {
            sb.append(String.format(" %s",m.toString()));
        });
        return  sb.toString();
    }
}
