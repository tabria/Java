package military_elite.entities;

public class Spy extends Soldier implements ISpy {

    private String codeNumber;

    public Spy(String id, String name, String lastName, String codeNumber) {
        super(id, name, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("%s%nCode Number: %s%n", super.toString(), this.codeNumber);
    }
}
