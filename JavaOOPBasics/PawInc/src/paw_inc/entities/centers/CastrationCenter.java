package paw_inc.entities.centers;

import paw_inc.entities.animals.Animal;

import java.util.*;

public class CastrationCenter extends Center {

    private Map<String, List<Animal>> animalsForCastration;

    public CastrationCenter(String name) {
        super(name);
        this.animalsForCastration = new HashMap<>();
    }

    public void addAnimalForCastrate(String name, Animal animal){
        this.animalsForCastration.putIfAbsent(name, new ArrayList<>());
        this.animalsForCastration.get(name).add(animal);
    };

    public Map<String, List<Animal>> getCastrateAnimal(){
        return Collections.unmodifiableMap(this.animalsForCastration);
    }

    public void removeCastratedAnimals(){
        this.animalsForCastration.clear();
    }


    @Override
    public void addAnimalForCleanse(String name, Animal animal) {

    }
}
