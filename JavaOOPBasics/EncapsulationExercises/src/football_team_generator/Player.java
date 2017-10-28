package football_team_generator;

public class Player {

    private static final double SKILL_COUNT = 5.0;
    private static final double SKILL_DEFAULT_VALUE = 0.0;

    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;


    public Player(String name) {
        setName(name);
        this.endurance = SKILL_DEFAULT_VALUE;
        this.sprint = SKILL_DEFAULT_VALUE;
        this.dribble = SKILL_DEFAULT_VALUE;
        this.passing = SKILL_DEFAULT_VALUE;
        this.shooting = SKILL_DEFAULT_VALUE;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.length()<=0 || name.matches("\\s+")){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

     private void setEndurance(double endurance) {
        if (endurance<0 || endurance>100){
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

     private void setSprint(double sprint) {
        if (sprint<0 || sprint>100){
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

     private void setDribble(double dribble) {
        if (dribble<0 || dribble>100){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

     private void setPassing(double passing) {
        if (passing<0 || passing>100){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

     private void setShooting(double shooting) {
        if (shooting<0 || shooting>100){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    String getName() {
        return this.name;
    }

    void addSkills(String[] skills){
        setEndurance(Double.parseDouble(skills[3]));
        setSprint(Double.parseDouble(skills[4]));
        setDribble(Double.parseDouble(skills[5]));
        setPassing(Double.parseDouble(skills[6]));
        setShooting(Double.parseDouble(skills[7]));
    }

    double playerOverallSkill(){
        return (this.dribble + this.endurance + this.passing + this.shooting + this.sprint)/SKILL_COUNT;
    }

}
