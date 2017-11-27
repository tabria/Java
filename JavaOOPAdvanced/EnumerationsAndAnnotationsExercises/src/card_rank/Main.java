package card_rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        CardRank[] ranks = CardRank.values();
        System.out.println(input + ":");
        for (CardRank rank :ranks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank.name());
        }

    }
}
