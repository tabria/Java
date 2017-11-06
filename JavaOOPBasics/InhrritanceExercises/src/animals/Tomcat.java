package animals;

public class Tomcat extends Cat {

    private String gender;

    public Tomcat(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String getGender() {
        return this.gender;
    }

    @Override
    protected void setGender(String gender) {
        this.gender = "Male";
    }
}
