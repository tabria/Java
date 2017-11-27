package equality_logic;

import java.util.Comparator;

public class PersonImpl implements Person, Comparable<Person> {

    private String name;
    private int age;

    public PersonImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(Person o) {
        int compareValue = this.getName().compareTo(o.getName());
        if (compareValue == 0){
            return this.getAge() - o.getAge();
        }
        return compareValue;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }

        if (obj instanceof Person){
            Person testPerson = (Person) obj;
            boolean compareValue = this.getName().equals(testPerson.getName());
            if (compareValue){
                return this.getAge() == testPerson.getAge();
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        final int prime = 7;
        int result = 1;
        result = prime * result + this.age;
        result = prime * result + this.name.hashCode();
        return result;
    }

}
