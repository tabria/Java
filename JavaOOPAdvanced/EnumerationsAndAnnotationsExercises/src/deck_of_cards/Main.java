package deck_of_cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        SuitPower[] suits = SuitPower.values();
        RankPower[] ranks = RankPower.values();
        for (SuitPower suit:suits) {
            for (RankPower rank:ranks) {
                System.out.printf("%s of %s%n", rank.name(), suit.name());
            }
        }
    }

}
