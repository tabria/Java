package wild_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringBuilder sbSound = new StringBuilder();

        while(true){
            String[] info = reader.readLine().split("\\s+");
            if ("End".equals(info[0])){
                break;
            }
            String[] infoFood = reader.readLine().split("\\s+");

            Controller.feedAnimal(info, infoFood, sb, sbSound);
        }
        System.out.print(sbSound);
        System.out.println(sb);

    }

}
