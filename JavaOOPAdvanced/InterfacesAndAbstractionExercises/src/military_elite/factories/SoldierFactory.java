package military_elite.factories;

import military_elite.engine.Engine;
import military_elite.entities.*;

import java.util.List;

public final class SoldierFactory {

    public static Private createPrivate(String id, String firstName, String lastName, Double salary){
        return new Private(id, firstName, lastName, salary);
    }

    public static LeutenantGeneral createLeutenantGeneral(String id, String firstName, String lastName, Double salary, List<Soldier> privates){
        return new LeutenantGeneral(id, firstName, lastName, salary, privates);
    }

    public static Engineer createEngineer(String id, String firstName, String lastName, Double salary, String corp, List<Repair> repairs){
        return new Engineer(id, firstName, lastName, salary, corp,  repairs);
    }

    public static Commando createCommando(String id, String firstName, String lastName, Double salary, String corp, List<Mission> missions){
        return new Commando(id, firstName, lastName, salary, corp,  missions);
    }

    public static Spy createSpy(String id, String firstName, String lastName, String number){
        return new Spy(id, firstName, lastName, number);
    }

}
