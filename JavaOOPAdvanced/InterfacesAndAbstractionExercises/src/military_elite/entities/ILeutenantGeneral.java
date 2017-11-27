package military_elite.entities;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public interface ILeutenantGeneral {


    List<Private> privates = new LinkedList<>();

    public List<Soldier> getPrivates();

}
