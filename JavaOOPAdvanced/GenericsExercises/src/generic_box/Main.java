package generic_box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Box> boxes = new LinkedList<>();
        int cycles = Integer.parseInt(reader.readLine());

        for (int i = 0; i <cycles ; i++) {
            Box newBox = new Box(reader.readLine());
            boxes.add(newBox);
        }

        for (Box box:boxes) {
            System.out.print(box);
        }
    }
}
