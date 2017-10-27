package google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> persons = new ArrayList<>();

        while(true){
            String[] personInfo = reader.readLine().split("\\s++");
            String name = personInfo[0];
            if ("End".equals(name)){
                break;
            }
            boolean isPersonExist = chckPersonExistance(persons, name);
            if (!isPersonExist){
                Person newPerson = new Person(name);
                persons.add(newPerson);
            }

            addPersonInfo(persons, personInfo);
        }
        String nameToPrint = reader.readLine();
        persons.stream().filter(x->x.getPersonName().equals(nameToPrint)).forEach(res -> {
            System.out.println(res);

        });

    }

    private static void addPersonInfo(List<Person> persons, String[] personInfo) {
        for (Person person: persons) {
            if (person.getPersonName().equals(personInfo[0])){
                switch(personInfo[1]){
                    case "company":
                        person.getPersonCompany().setCompanyName(personInfo[2]);
                        person.getPersonCompany().setDepartment(personInfo[3]);
                        person.getPersonCompany().setSalary(Double.valueOf(personInfo[4]));
                        break;
                    case "car":
                        person.getPersonCar().setCarModel(personInfo[2]);
                        person.getPersonCar().setCarSpeed(personInfo[3]);
                        break;
                    case "pokemon":
                        addLatestPokemon(person, personInfo);
                        break;
                    case "parents":
                        addLatestParent(person, personInfo);
                        break;
                    case "children":
                        addLatestChild(person, personInfo);
                        break;
                }
            }
        }
    }

    private static void addLatestChild(Person person, String[] personInfo) {
        boolean isChildrenAddd = false;
        for (Child child: person.getPersonChildren()) {
            if (child.getChildName().equals(personInfo[2])){
                child.setChildBirthday(personInfo[3]);
                isChildrenAddd = true;
                break;
            }
        }
        if (!isChildrenAddd){
            Child newChild = new Child(personInfo[2], personInfo[3]);
            person.setPersonChildren(newChild);
        }
    }

    private static void addLatestParent(Person person, String[] personInfo) {
        boolean isParentAddd = false;
        for (Parent parent: person.getPersonParents()) {
            if (parent.getParentName().equals(personInfo[2])){
                parent.setParentBirthday(personInfo[3]);
                isParentAddd = true;
                break;
            }
        }
        if (!isParentAddd){
            Parent newParent = new Parent(personInfo[2], personInfo[3]);
            person.setPersonParents(newParent);
        }
    }

    private static void addLatestPokemon(Person person, String[] personInfo) {
        boolean isPokemonAdded = false;
        for (Pokemon pokemon: person.getPersonPokemons()) {
            if (pokemon.getPokemonName().equals(personInfo[2])){
                pokemon.setPokemonType(personInfo[3]);
                isPokemonAdded = true;
                break;
            }
        }
        if (!isPokemonAdded){
            Pokemon newPokemon = new Pokemon(personInfo[2], personInfo[3]);
            person.setPersonPokemons(newPokemon);
        }
    }

    private static boolean chckPersonExistance(List<Person> persons, String name) {
        for (Person person:persons) {
            if (name.equals(person.getPersonName())){
                return true;
            }
        }
        return false;
    }

}
