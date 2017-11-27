package military_elite.entities;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {

    private List<Soldier> privates;

    public LeutenantGeneral(String id, String name, String lastName, double salary, List<Soldier> privates) {
        super(id, name, lastName, salary);
        this.privates = privates;
    }

    public List<Soldier> getPrivates() {
        return Collections.unmodifiableList(this.privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%sPrivates:%n",super.toString()));
        this.getPrivates().stream().sorted((p1 , p2)->p2.getId().compareTo(p1.getId())).forEach(p-> {
            sb.append(String.format(" %s",p.toString()));
        });
        return  sb.toString();
    }
}
