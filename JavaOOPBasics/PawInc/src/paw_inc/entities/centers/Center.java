package paw_inc.entities.centers;

import paw_inc.entities.animals.Animal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class Center {

    private String name;

    protected Center(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public abstract void addAnimalForCleanse(String name, Animal animal);
    public void addAnimalForCastrate(String name, Animal animal){};
    public List<Animal> getAnimalsForAdoption() {return null;};
    public List<Animal> getAnimalsForCleanse(){ return null; };
    public Map<String, List<Animal>> getCastrateAnimal(){return null;}
    public Map<String, List<Animal>> getCleanseAnimal(){ return null;};
    public void removeCastratedAnimals(){};
    public void removeCleansedAnimals(){};
    public void cleanAnimalsForAdoption() {};
    public void cleanAnimalsForCleanse() {};
    public void addAnimalForAdoption(Animal animal){}
}
