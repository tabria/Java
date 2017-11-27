package border_control;

import java.util.regex.Pattern;

public class Citizen extends Habitant {

    private String name;
    private int age;

    protected Citizen(String name, int age, String id) {
        super(id);
        this.name = name;
        this.age = age;
    }

    @Override
    public void printDetainedId(String idEnd) {
        Pattern pattern = Pattern.compile(String.format(".*%s", idEnd));
        if (pattern.matcher(super.getId()).matches()){
            System.out.println(super.getId());
        }
    }
}
