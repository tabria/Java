package food_shortage;

import java.util.regex.Pattern;

public class Robot extends Habitant {

    private String model;

    protected Robot(String model, String id) {
        super(id);
        this.model = model;
    }

    @Override
    public void printDetainedId(String idEnd) {
        Pattern pattern = Pattern.compile(String.format(".*%s", idEnd));
        if (pattern.matcher(super.getId()).matches()){
            System.out.println(super.getId());
        }
    }
}
