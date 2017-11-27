package military_elite.entities;

public abstract class Soldier implements ISoldier {

    private String id;
    private String name;
    private String lastName;

    protected Soldier(String id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s ", this.getName(), this.getLastName(), this.getId());
    }
}
