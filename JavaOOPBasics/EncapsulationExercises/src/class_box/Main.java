package class_box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        double inputLength = Double.parseDouble(reader.readLine());
        double inputWidth = Double.parseDouble(reader.readLine());
        double inputHeight = Double.parseDouble(reader.readLine());

        try {
            Box newBox = new Box(inputLength, inputWidth, inputHeight);
            System.out.printf("Surface Area - %.2f%n",newBox.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", newBox.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f", newBox.calculateVolume());

        } catch (IllegalArgumentException ias){
            System.out.println(ias.getMessage());
        }


    }

}
