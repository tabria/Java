package paw_inc.entities.centers;


import paw_inc.entities.animals.Animal;
import paw_inc.utilities.Constants;

import java.util.*;

public class CleansingCenter extends Center {


    private Map<String, List<Animal>> animalsForCleanse;

    public CleansingCenter(String name) {
        super(name);
        this.animalsForCleanse = new HashMap<>();
    }


    public Map<String, List<Animal>> getCleanseAnimal(){
        return Collections.unmodifiableMap(this.animalsForCleanse);
    }

    public void removeCleansedAnimals(){
        this.animalsForCleanse.clear();
    }

    @Override
    public void addAnimalForCleanse(String name, Animal animal) {
        this.animalsForCleanse.putIfAbsent(name, new ArrayList<>());
        this.animalsForCleanse.get(name).add(animal);
    }



}
