package military_elite.entities;

import java.util.LinkedList;
import java.util.List;

public interface ICommando {

    List<Mission> missions = new LinkedList<>();

    List<Mission> getMissions();
}
