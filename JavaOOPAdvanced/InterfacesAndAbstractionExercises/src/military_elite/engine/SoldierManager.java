package military_elite.engine;

import military_elite.entities.Mission;
import military_elite.entities.Private;
import military_elite.entities.Repair;
import military_elite.entities.Soldier;
import military_elite.factories.MissionFactory;
import military_elite.factories.RepairFactory;
import military_elite.factories.SoldierFactory;

import java.util.*;

public class SoldierManager {


    private Map<String, Soldier> soldiers;


    public SoldierManager() {
        this.soldiers = new LinkedHashMap<>();
    }


    public Map<String, Soldier> getSoldiers() {
        return Collections.unmodifiableMap(this.soldiers);
    }

    public void addPrivate(String id, String firstName, String lastName, double salary) {
        soldiers.put(id, SoldierFactory.createPrivate(id, firstName, lastName, salary));
    }

    public void addLeutenantGeneral(List<String> command) {
        List<String> privatesID = new ArrayList<>(command.subList(5, command.size()));
        List<Soldier> generalPrivates = new LinkedList<>();
        addPrivatesToGeneral(privatesID, generalPrivates);
        soldiers.put(command.get(1), SoldierFactory.createLeutenantGeneral(command.get(1), command.get(2), command.get(3), Double.parseDouble(command.get(4)), generalPrivates));
    }

    private void addPrivatesToGeneral(List<String> privatesID, List<Soldier> privates) {
        for (String id : privatesID) {
            if (this.getSoldiers().get(id).getId()
                    .equals(id) && this.getSoldiers().get(id).getClass().getSimpleName().equals("Private")) {
                privates.add(this.getSoldiers().get(id));
            }
        }
    }

    public void addEngineer(List<String> command) {
        List<String> repairsInput = new ArrayList<>(command.subList(6, command.size()));
        List<Repair> repairs = new LinkedList<>();
        addRepairs(repairsInput, repairs);
        try {
            soldiers.put(command.get(1), SoldierFactory.createEngineer(command.get(1), command.get(2), command.get(3), Double.parseDouble(command.get(4)), command.get(5), repairs));
        } catch (IllegalArgumentException iae) {

        }
    }

    private void addRepairs(List<String> repairsInput, List<Repair> repairs) {
        for (int i = 0; i < repairsInput.size(); i += 2) {
            repairs.add(RepairFactory.createRepair(repairsInput.get(i), Integer.parseInt(repairsInput.get(i + 1))));
        }
    }

    public void addCommando(List<String> command) {
        List<String> missionsInput = new ArrayList<>(command.subList(6, command.size()));
        List<Mission> missions = new LinkedList<>();
        addMission(missionsInput, missions);
        try {
            soldiers.put(command.get(1), SoldierFactory.createCommando(command.get(1), command.get(2), command.get(3), Double.parseDouble(command.get(4)), command.get(5), missions));
        } catch (IllegalArgumentException iae) {

        }
    }

    private void addMission(List<String> missionsInput, List<Mission> missions) {
        for (int i = 0; i < missionsInput.size(); i += 2) {
            try {
                missions.add(MissionFactory.createMission(missionsInput.get(i), missionsInput.get(i + 1)));
            } catch (IllegalArgumentException iae) {
            }
            ;

        }
    }

    public void addSpy(String id, String firstName, String lastName, String codeNumber) {
        soldiers.put(id, SoldierFactory.createSpy(id, firstName, lastName, codeNumber));
    }
}
