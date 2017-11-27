package military_elite.entities;

import java.util.LinkedList;
import java.util.List;

public interface IEngineer {

    List<Repair> repairs = new LinkedList<>();

    List<Repair> getRepairs();

}
