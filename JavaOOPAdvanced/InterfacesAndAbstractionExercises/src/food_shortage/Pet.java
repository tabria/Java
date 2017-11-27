package food_shortage;

import java.util.regex.Pattern;

public class Pet extends NonRobots {


    public Pet(String name, String birthday) {
        super(name, birthday);
    }


    @Override
    public void printBirthday(String year) {
        Pattern pattern = Pattern.compile(String.format(".*%s", year));
        if (pattern.matcher(this.getBirthday()).matches()){
            System.out.println(this.getBirthday());
        }
    }
}
