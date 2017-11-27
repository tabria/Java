package traffic_lights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] lights = reader.readLine().split("\\s+");
        int cycles = Integer.parseInt(reader.readLine());

        TrafficLight newTrafficLight = new TrafficLightImpl();
        newTrafficLight.addColors(lights);
        for (int i = 0; i <cycles ; i++) {
            newTrafficLight.changeLights();
            System.out.println(newTrafficLight.extractAllColors());
        }
    }
}
