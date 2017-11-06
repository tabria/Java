package mordor_cruelty_plan;

public class Gandalf {

    private int happiness;

    public Gandalf() {
        this.happiness=0;
    }

    private void setHappiness(String[] foods) {
       this.happiness = getFoodHappiness(foods);

    }

    private int getFoodHappiness(String[] foods) {
        int happy = 0;
        for (String food:foods) {
            switch(food.toLowerCase()){
                case "cram":
                    happy += 2;
                    break;
                case "lembas":
                    happy+=3;
                    break;
                case "apple":
                case "melon":
                    happy+=1;
                    break;
                case "honeycake":
                    happy+=5;
                    break;
                case "mushrooms":
                    happy -=10;
                    break;
                default:
                    happy -= 1;
                    break;
            }
        }
        return happy;
    }

    protected void eatFood (String[] foods){
        setHappiness(foods);
    }

    private int getHappiness() {
        return this.happiness;
    }

    private String getGandalfMood(){
        String mood = "Angry";
        if (getHappiness()>= -5 && getHappiness()<0){
            mood = "Sad";
        } else if (getHappiness()>=0 && getHappiness() <= 15){
            mood = "Happy";
        } else if (getHappiness() > 15){
            mood = "JavaScript";
        }

        return mood;
    }

    @Override
    public String toString() {
        return getHappiness() + "\r\n" + getGandalfMood();
    }
}
