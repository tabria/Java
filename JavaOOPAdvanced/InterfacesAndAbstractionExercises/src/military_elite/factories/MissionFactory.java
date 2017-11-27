package military_elite.factories;

import military_elite.entities.Mission;

public final class MissionFactory {

    public static Mission createMission(String codename, String status){
        return new Mission(codename, status);
    }

}
