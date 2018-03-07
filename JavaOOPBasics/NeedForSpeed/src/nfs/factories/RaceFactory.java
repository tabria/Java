package nfs.factories;

import nfs.entities.races.*;

public final class RaceFactory {

    public static Race create(String type, int length, String route, int prizePool){
        Race race = null;
        switch(type){
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool);
                break;
            default:
                return null;
        }
        return race;
    }

    public static Race create(String type, int length, String route, int prizePool, int timeOrLap){
        Race race = null;
        switch(type){
            case "TimeLimit":
                race = new TimeLimitRace(length, route, prizePool, timeOrLap);
                break;
            case "Circuit":
                race = new CircuitRace(length, route, prizePool, timeOrLap);
                break;
            default:
                return null;
        }
        return race;
    }

}
