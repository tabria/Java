package cards_with_power;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        RankPower rankPower = RankPower.valueOf(reader.readLine());
        SuitPower suitPower = SuitPower.valueOf(reader.readLine());

        System.out.println(new Card(rankPower, suitPower));
    }
}
