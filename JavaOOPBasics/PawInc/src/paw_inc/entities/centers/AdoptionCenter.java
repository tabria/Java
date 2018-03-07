package paw_inc.entities.centers;

import paw_inc.entities.animals.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdoptionCenter extends Center {

    private List<Animal> animalsForCleanse;
    private List<Animal> animalsForAdoption;


    public AdoptionCenter(String name) {
        super(name);
        this.animalsForCleanse = new ArrayList<>();
        this.animalsForAdoption = new ArrayList<>();
    }



    public List<Animal> getAnimalsForAdoption() {
        return Collections.unmodifiableList(this.animalsForAdoption);
    }

    public void cleanAnimalsForAdoption() {
        this.animalsForAdoption.clear();
    }

    public void cleanAnimalsForCleanse() {
        this.animalsForCleanse.clear();
    }

    public List<Animal> getAnimalsForCleanse() {
        return Collections.unmodifiableList(this.animalsForCleanse);
    }

    public void addAnimalForAdoption(Animal animal){
        this.animalsForAdoption.add(animal);
    }

    @Override
    public void addAnimalForCleanse(String name, Animal animal){
        this.animalsForCleanse.add(animal);
    }



}
