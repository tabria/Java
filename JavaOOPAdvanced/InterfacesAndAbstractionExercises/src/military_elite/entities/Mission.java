package military_elite.entities;

public class Mission implements IMission {

    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void setState(String state) {
        if (state.equals("inProgress") || state.equals("Finished")){
            this.state = state;
        } else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public void CompleteMission() {
        if (this.getState().equals("inProgress")){
            this.setState("Finished");
        }
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s%n", this.codeName, this.getState());
    }
}
