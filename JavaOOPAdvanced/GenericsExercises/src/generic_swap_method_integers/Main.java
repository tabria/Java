package generic_swap_method_integers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        IBox newBox = new Box();


        int cycles = Integer.parseInt(reader.readLine());
        for (int i = 0; i <cycles ; i++) {
            newBox.addElement(Integer.parseInt(reader.readLine()));
        }
        String[] swatIndex = reader.readLine().split("\\s+");
        newBox.swap(newBox.getElements(), Integer.parseInt(swatIndex[0]), Integer.parseInt(swatIndex[1]));
        System.out.println(newBox);
    }
}
