package need_for_speed.factorie;

import need_for_speed.entitis.races.CasualRace;
import need_for_speed.entitis.races.DragRace;
import need_for_speed.entitis.races.DriftRace;

public final class RaceFactory {


    public static CasualRace createCasualRace(int length, String route, int prizePool){
        return new CasualRace(length, route, prizePool);
    }

    public static DragRace createDragRace(int length, String route, int prizePool){
        return new DragRace(length, route, prizePool);
    }

    public static DriftRace createDriftRace(int length, String route, int prizePool){
        return new DriftRace(length, route, prizePool);
    }
}
