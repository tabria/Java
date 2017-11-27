package military_elite.entities;

public abstract class SpecialisedSoldier extends Private {

    String corp;

    protected SpecialisedSoldier(String id, String name, String lastName, double salary, String corp) {
        super(id, name, lastName, salary);
        this.setCorp(corp);
    }

    public String getCorp() {
        return this.corp;
    }

    public void setCorp(String corp) {
       if (corp.equals("Airforces") || corp.equals("Marines")) {
           this.corp = corp;
       } else {
           throw new IllegalArgumentException();
       }

    }

    @Override
    public String toString() {
        return String.format("%sCorps: %s%n", super.toString(), this.getCorp());
    }
}
