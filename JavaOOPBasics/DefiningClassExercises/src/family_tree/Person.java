package family_tree;

import java.util.*;

public class Person {

    public static final String DEFAULT_NAME = "";


    private String name;
    private String birthday;
    private List<Person> personParents;
    private List<Person> personChildrens;

    public Person() {
        this.name = DEFAULT_NAME;
        this.birthday = DEFAULT_NAME;
        this.personParents = new LinkedList<>();
        this.personChildrens = new LinkedList<>();
    }

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.personParents = new LinkedList<>();
        this.personChildrens = new LinkedList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Person> getPersonParents() {
        return this.personParents;
    }

    public void addPersonParents(Person personParents) {
        this.getPersonParents().add(personParents);
    }

    public List<Person> getPersonChildrens() {
        return this.personChildrens;
    }

    public void addPersonChildrens(Person personChildrens) {
        this.getPersonChildrens().add(personChildrens);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.name)
                .append(" ")
                .append(this.birthday)
                .append(System.lineSeparator());
        result.append("Parents:")
                .append(System.lineSeparator());
        if (this.personParents.size() > 0){
            for (Person parent : this.personParents) {
                result.append(parent.getName())
                        .append(" ")
                        .append(parent.getBirthday())
                        .append(System.lineSeparator());
            }
        }
        result.append("Children:").append(System.lineSeparator());
        if (this.personChildrens.size() > 0){
            for (Person children : this.personChildrens) {
                result.append(children.getName())
                        .append(" ")
                        .append(children.getBirthday())
                        .append(System.lineSeparator());
            }
        }
        return result.toString();
    }
}
