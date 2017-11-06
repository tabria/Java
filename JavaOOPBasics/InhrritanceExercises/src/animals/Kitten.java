package animals;

public class Kitten extends Cat {

    private String gender;

    public Kitten(String name, String age, String gender) {
        super(name, age, gender);
    }


    @Override
    protected String getGender() {
        return this.gender;
    }

    @Override
    protected void setGender(String gender) {
        this.gender = "Female";
    }
}
