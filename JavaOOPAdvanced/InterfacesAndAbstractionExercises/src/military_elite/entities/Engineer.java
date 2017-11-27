package military_elite.entities;

import java.util.Collections;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {

    private List<Repair> repairs;

    public Engineer(String id, String name, String lastName, double salary, String corp, List<Repair> repairs) {
        super(id, name, lastName, salary, corp);
        this.repairs = repairs;
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%sRepairs:%n",super.toString()));
        this.getRepairs().forEach(r-> {
            sb.append(String.format(" %s",r.toString()));
        });
        return  sb.toString();
    }
}
