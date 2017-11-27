package traffic_lights;

import java.util.*;

public class TrafficLightImpl implements TrafficLight {

    private List<Color> trafficLight;


    public TrafficLightImpl() {
        this.trafficLight = new LinkedList<>();
    }

    @Override
    public void addColors(String[] lights){
        for (int i = 0; i < lights.length ; i++) {
            this.trafficLight.add(Color.valueOf(lights[i]));
        }
    }

    @Override
    public void changeLights() {
        for (int i = 0; i <this.trafficLight.size() ; i++) {
            switch(this.trafficLight.get(i).name()){
                case "RED":
                    this.trafficLight.set(i,Color.GREEN);
                    break;
                case "GREEN":
                    this.trafficLight.set(i, Color.YELLOW);
                    break;
                case "YELLOW":
                    this.trafficLight.set(i, Color.RED);
                    break;
            }
        }
    }

    @Override
    public String extractAllColors(){
        StringBuilder sb = new StringBuilder();
        Iterator<Color> itr = this.trafficLight.iterator();

        while(itr.hasNext()){
            sb.append(itr.next().name()).append(" ");
        }

        return sb.toString().trim();
    }

}
