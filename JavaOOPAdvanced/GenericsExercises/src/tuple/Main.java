package tuple;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split("\\s+");
        System.out.println(new Tuple<>(firstLine[0] + " " + firstLine[1], firstLine[2]));

        String[] secondLine = reader.readLine().split("\\s+");
        System.out.println(new Tuple<>(secondLine[0], Integer.parseInt(secondLine[1])));

        String[] thirdLine = reader.readLine().split("\\s+");
        Tuple<Integer, Double> newTuple = new Tuple<>(Integer.parseInt(thirdLine[0]), Double.parseDouble(thirdLine[1]));
        System.out.println(newTuple);

    }

}
