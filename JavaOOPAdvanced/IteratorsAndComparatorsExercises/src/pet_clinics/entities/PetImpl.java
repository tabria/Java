package pet_clinics.entities;

import pet_clinics.interfaces.Pet;

public class PetImpl implements Pet {

    private String name;
    private int age;
    private String kind;

    public PetImpl(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    private String getName() {
        return this.name;
    }

    private int getAge() {
        return this.age;
    }

    private String getKind() {
        return this.kind;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s",this.getName(),this.getAge(),this.getKind());
    }
}
