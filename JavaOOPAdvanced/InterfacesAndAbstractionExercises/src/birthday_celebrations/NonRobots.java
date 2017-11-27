package birthday_celebrations;

public abstract class NonRobots implements Naturable {

    private String birthday;
    private String name;

    public NonRobots(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
