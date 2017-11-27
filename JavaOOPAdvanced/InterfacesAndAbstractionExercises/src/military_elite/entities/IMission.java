package military_elite.entities;

public interface IMission {

    String codeName ="";
    String state ="";

    void CompleteMission();
    public String getState();
    public void setState(String state);
}
