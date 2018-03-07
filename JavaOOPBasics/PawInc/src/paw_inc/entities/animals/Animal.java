package paw_inc.entities.animals;

import paw_inc.utilities.Constants;

public abstract class Animal {

    private String name;
    private int age;
    private String cleansingStatus;

    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.cleansingStatus = Constants.UNCLEANSED_ANIMAL_STATUS;
    }


    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getCleansingStatus() {
        return this.cleansingStatus;
    }

    public void setCleansingStatus(String cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
