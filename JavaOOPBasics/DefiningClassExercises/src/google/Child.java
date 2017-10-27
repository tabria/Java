package google;

public class Child {

    private final static String DEFAULT_VALUE = "";

    private String childName;
    private String childBirthday;

    public Child(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    public String getChildName() {
        return this.childName;
    }

    public void setChildBirthday(String childBirthday) {
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {
        return childName + " " + childBirthday;
    }
}
