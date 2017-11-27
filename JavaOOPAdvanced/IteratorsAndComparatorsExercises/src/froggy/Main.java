package froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Integer[] numbers = Arrays.stream(reader.readLine().split("[\\s,]+")).map(Integer::parseInt).toArray(Integer[]::new);
        Lake<Integer> newLake = new Lake<>(numbers);

        String command = reader.readLine();
        if ("END".equals(command)){
            List<String> result = new ArrayList<>();
            for (Integer integer : newLake) {
                result.add(String.valueOf(integer));
            }

            System.out.println(String.join(", ", result));
        }
    }
}
