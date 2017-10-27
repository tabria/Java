package google;


import java.util.ArrayList;
import java.util.List;

public class Person {

    private String personName;
    private Car personCar;
    private Company personCompany;
    private List<Parent> personParents;
    private List<Child> personChildren;
    private List<Pokemon> personPokemons;

    public Person(String personName) {
        this.personName = personName;
        this.personCar = new Car();
        this.personCompany = new Company();
        this.personParents = new ArrayList<>();
        this.personChildren = new ArrayList<>();
        this.personPokemons = new ArrayList<>();
    }

    public String getPersonName() {
        return this.personName;
    }

    public Company getPersonCompany() {
        return this.personCompany;
    }

    public Car getPersonCar() {
        return this.personCar;
    }

    public List<Parent> getPersonParents() {
        return new ArrayList<>(this.personParents);
    }

    public void setPersonParents(Parent parent) {
        this.personParents.add(parent);
    }

    public List<Child> getPersonChildren() {
        return personChildren;
    }

    public void setPersonChildren(Child child) {
        this.personChildren.add(child);
    }

    public List<Pokemon> getPersonPokemons() {
        return new ArrayList<>(this.personPokemons);
    }

    public void setPersonPokemons(Pokemon pokemon) {
        this.personPokemons.add(pokemon);
    }

    @Override
    public String toString() {
        return personName + "\r\n" +
                "Company:" +
                printPersonCompany(this.personCompany) + "\r\n" +
                "Car:" +
                printPersonCar(this.personCar) + "\r\n" +
                "Pokemon:" +
                printPersonPokemons(this.personPokemons) + "\r\n" +
                "Parents:" +
                printPersonParents(this.personParents) + "\r\n" +
                "Children:" +
                printPersonChildren(this.personChildren);
    }

    private String printPersonCompany(Company personCompany) {
        if (personCompany.getCompanyName().isEmpty()){
            return "";
        } else {
            return "\r\n" + personCompany;
        }
    }

    private String printPersonCar(Car personCar) {
        if (personCar.getCarModel().isEmpty()){
            return "";
        } else {
            return "\r\n" + personCar;
        }
    }

    private String printPersonPokemons(List<Pokemon> personPokemons) {
        if (personPokemons.size()<1){
            return "";
        } else {
            return "\r\n" + personPokemons.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", ", "\r\n");
        }
    }

    private String printPersonParents(List<Parent> personParents) {
        if (personParents.size()<1){
            return "";
        } else {
            return "\r\n" + personParents.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", ", "\r\n");
        }
    }

    private String printPersonChildren(List<Child> personChildren) {
        if (personChildren.size()<1){
            return "";
        } else {
            return "\r\n" + personChildren.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", ", "\r\n");
        }
    }
}
