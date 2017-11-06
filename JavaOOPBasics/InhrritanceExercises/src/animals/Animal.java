package animals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Animal {

    private String name;
    private int age;
    private String gender;
    private HashMap<String, String> sound;

    public Animal(String name, String age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
        this.setSound();
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length()<1 || name.trim().matches("\\d+")){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private int getAge() {
        return this.age;
    }

    private void setAge(String age) {
        int currentAge;
        try {
            currentAge = Integer.parseInt(age.trim());
        } catch (Exception e){
            throw new IllegalArgumentException("Invalid input!");
        }
        if (currentAge < 1){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = currentAge;
    }

    protected String getGender() {
        return this.gender;
    }

    protected void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty() || gender.trim().length()<1 || gender.trim().matches("\\d+")){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    private void setSound() {
        this.sound = new HashMap<String, String>() {{
            put("Dog", "BauBau");
            put("Cat", "MiauMiau");
            put("Frog", "Frogggg");
            put("Kitten", "Miau");
            put("Tomcat","Give me one million b***h" );
        }};
    }

    private Map<String, String> getSound() {
        return Collections.unmodifiableMap(this.sound);
    }

    private String produceSound(){
        if (getSound().containsKey(getClass().getSimpleName())){
            return getSound().get(getClass().getSimpleName());
        }
        return "Not implemented!";
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName())
                .append(System.lineSeparator())
                .append(getName())
                .append(" ")
                .append(getAge())
                .append(" ")
                .append(getGender())
                .append(System.lineSeparator())
                .append(produceSound());

        return sb.toString();
    }
}
