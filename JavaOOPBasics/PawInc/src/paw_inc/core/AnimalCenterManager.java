package paw_inc.core;

import paw_inc.entities.animals.Animal;
import paw_inc.entities.centers.Center;
import paw_inc.factories.AnimalFactory;
import paw_inc.factories.CenterFactory;
import paw_inc.utilities.Constants;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager {

    private Map<String, Center> cleansingCenters;
    private Map<String, Center> adoptionCenters;
    private Map<String, Center> castrationCenters;
    private List<String> cleansedAnimals;
    private List<String> castratedAnimals;
    private List<Animal> adoptedAnimals;

    public AnimalCenterManager() {
        this.cleansingCenters = new HashMap<>();
        this.adoptionCenters = new HashMap<>();
        this.cleansedAnimals = new ArrayList<>();
        this.adoptedAnimals = new ArrayList<>();
        this.castratedAnimals = new ArrayList<>();
        this.castrationCenters = new HashMap<>();
    }

    public void registerCleansingCenter(String name){
        if (!this.cleansingCenters.containsKey(name)){
            this.cleansingCenters.put(name, CenterFactory.createCleansingCenter(name));
        }
    }

    public void registerAdoptionCenter(String name){
        if (!this.adoptionCenters.containsKey(name)){
            this.adoptionCenters.put(name, CenterFactory.createAdoptionCenter(name));
        }
    }

    public void registerCastrationCenter(String name){
        if (!this.castrationCenters.containsKey(name)){
            this.castrationCenters.put(name, CenterFactory.createCastrationCenter(name));
        }
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName){
        if ( this.adoptionCenters.containsKey(adoptionCenterName)){
            Animal newAnimal = AnimalFactory.createDog(name, age, learnedCommands);
            this.adoptionCenters.get(adoptionCenterName).addAnimalForCleanse(adoptionCenterName, newAnimal);
        }
    }
    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName){
        if (this.adoptionCenters.containsKey(adoptionCenterName)){
            Animal newAnimal = AnimalFactory.createCat(name, age, intelligenceCoefficient);
            this.adoptionCenters.get(adoptionCenterName).addAnimalForCleanse(adoptionCenterName, newAnimal);
        }
    }
    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName){
        if (this.adoptionCenters.containsKey(adoptionCenterName) && this.cleansingCenters.containsKey(cleansingCenterName)){
            for (Animal animal:this.adoptionCenters.get(adoptionCenterName).getAnimalsForCleanse()) {
                if (animal.getCleansingStatus().equals(Constants.UNCLEANSED_ANIMAL_STATUS)){
                    this.cleansingCenters.get(cleansingCenterName).addAnimalForCleanse(adoptionCenterName, animal);
                }
            }
            this.adoptionCenters.get(adoptionCenterName).cleanAnimalsForCleanse();
        }
    }

    public void SendForCastration(String adoptionCenterName, String cleansingCenterName){
        if (this.adoptionCenters.containsKey(adoptionCenterName) && this.castrationCenters.containsKey(cleansingCenterName)){
            for (Animal animal:this.adoptionCenters.get(adoptionCenterName).getAnimalsForCleanse()) {
                if (animal.getCleansingStatus().equals(Constants.UNCLEANSED_ANIMAL_STATUS)){
                    this.castrationCenters.get(cleansingCenterName).addAnimalForCastrate(adoptionCenterName, animal);
                }
            }
            this.adoptionCenters.get(adoptionCenterName).cleanAnimalsForCleanse();
        }
    }

    public void cleanse(String cleansingCenterName){

        if (this.cleansingCenters.containsKey(cleansingCenterName)){
            Center center = this.cleansingCenters.get(cleansingCenterName);
            if (center.getCleanseAnimal() != null){
                for (Map.Entry<String, List<Animal>> animalEntrySet : center.getCleanseAnimal().entrySet()) {
                    String adoptionCenterName = animalEntrySet.getKey();
                    for (Animal animal : animalEntrySet.getValue()) {
                        animal.setCleansingStatus(Constants.CLEANSED_ANIMAL_STATUS);
                        this.cleansedAnimals.add(animal.getName());
                        this.adoptionCenters.get(adoptionCenterName).addAnimalForAdoption(animal);
                    }
                }
            }
            center.removeCleansedAnimals();
        }
    }

    public void castrate(String castrateCenterName){

        if (this.castrationCenters.containsKey(castrateCenterName)){
            Center center = this.castrationCenters.get(castrateCenterName);
            if (center.getCastrateAnimal() != null){
                for (Map.Entry<String, List<Animal>> animalEntrySet : center.getCastrateAnimal().entrySet()) {
                    String adoptionCenterName = animalEntrySet.getKey();
                    for (Animal animal : animalEntrySet.getValue()) {
                        this.castratedAnimals.add(animal.getName());
                        this.adoptionCenters.get(adoptionCenterName).addAnimalForCleanse(adoptionCenterName, animal);
                    }
                }
            }
            center.removeCastratedAnimals();
        }
    }

    public void adopt(String adoptionCenterName){
        if (this.adoptionCenters.containsKey(adoptionCenterName)){
            Center center = this.adoptionCenters.get(adoptionCenterName);
            if (center.getAnimalsForAdoption() != null){
                this.adoptedAnimals.addAll(center.getAnimalsForAdoption());
                center.cleanAnimalsForAdoption();
            }
        }
    }

    public void castrationStatistics (){
        StringBuilder sb = new StringBuilder();

        Collections.sort(this.castratedAnimals);

        sb.append("Paw Inc. Regular Castration Statistics\r\n")
                .append(String.format("Castration Centers: %d%n", this.castrationCenters.size()))
                .append(String.format("Castrated Animals: %s%n", this.castratedAnimals.size() !=0 ? String.join(", ", this.castratedAnimals) : "None"));

        System.out.print(sb.toString());

    }

    public void printStatistics(){
        StringBuilder sb = new StringBuilder();

        List<Animal> sortedAdoption = this.adoptedAnimals.stream().sorted((a1, a2) -> a1.getName().compareTo(a2.getName()))
                .collect(Collectors.toList());

        Collections.sort(this.cleansedAnimals);

        int awaitingAdoption = 0;
        for (Map.Entry<String, Center> centerEntry:this.adoptionCenters.entrySet()) {
           awaitingAdoption += centerEntry.getValue().getAnimalsForAdoption().size();
        };

        int awaitingCleansintg = 0;
        for (Map.Entry<String, Center> centerEntry:this.cleansingCenters.entrySet()) {
            for (Map.Entry<String, List<Animal>> animalEntry: centerEntry.getValue().getCleanseAnimal().entrySet()) {
                awaitingCleansintg += animalEntry.getValue().size();
            }
        };

        sb.append("Paw Incorporative Regular Statistics\r\n")
                .append(String.format("Adoption Centers: %d%n", this.adoptionCenters.size()))
                .append(String.format("Cleansing Centers: %d%n", this.cleansingCenters.size()))
                .append(String.format("Adopted Animals: %s%n", this.adoptedAnimals.size() !=0 ? sortedAdoption.stream().map(Object::toString).collect(Collectors.joining(", ")) : "None"))
                .append(String.format("Cleansed Animals: %s%n", this.cleansedAnimals.size() !=0 ? String.join(", ", this.cleansedAnimals) : "None"))
                .append(String.format("Animals Awaiting Adoption: %d%n", awaitingAdoption))
                .append(String.format("Animals Awaiting Cleansing: %d%n", awaitingCleansintg));

        System.out.println(sb.toString());
    }

}
