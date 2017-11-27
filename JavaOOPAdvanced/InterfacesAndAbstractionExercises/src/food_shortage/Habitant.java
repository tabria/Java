package food_shortage;

public abstract class Habitant implements Detainable {

    private String id;

    protected Habitant(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.getId();
    }
}
