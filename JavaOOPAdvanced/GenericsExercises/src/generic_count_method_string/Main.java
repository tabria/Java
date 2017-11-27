package generic_count_method_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        IBox newBox = new Box();


        int cycles = Integer.parseInt(reader.readLine());
        for (int i = 0; i <cycles ; i++) {
            newBox.addElement(Double.parseDouble(reader.readLine()));
        }
        Double comp = Double.parseDouble(reader.readLine());
        System.out.println( newBox.compare(newBox.getElements(), comp));
    }
}
