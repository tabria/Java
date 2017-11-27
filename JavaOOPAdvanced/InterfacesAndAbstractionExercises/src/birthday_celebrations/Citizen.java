package birthday_celebrations;

import java.util.regex.Pattern;

public class Citizen extends NonRobots {

    private String id;
    private int age;

    public Citizen(String name, int age, String id, String birthday) {
        super(name, birthday);
        this.id = id;
        this.age = age;
    }

    @Override
    public void printBirthday(String year) {
        Pattern pattern = Pattern.compile(String.format(".*%s", year));
        if (pattern.matcher(this.getBirthday()).matches()){
            System.out.println(this.getBirthday());
        }
    }

    @Override
    public String getBirthday() {
        return super.getBirthday();
    }
}
