package comparing_objects;

public class Person implements Comparable<Person> {
   private String name;
   private int age;
   private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person o) {
        if (this.getName().equals(o.getName())){
            if (this.getAge() == o.getAge()){
                return this.getTown().compareTo(o.getTown());
            } else {
                return this.getAge() - o.getAge();
            }
        } else {
            return this.getName().compareTo(o.getName());
        }

//        if (this.name.compareTo(o.name) != 0) {
//            return this.name.compareTo(o.name);
//        } else if (Integer.compare(this.age, o.age) != 0) {
//            return Integer.compare(this.age, o.age);
//        } else {
//            return this.town.compareTo(o.town);
//        }
    }
}
