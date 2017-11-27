package card_compareto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        RankPower rankPower = RankPower.valueOf(reader.readLine());
        SuitPower suitPower = SuitPower.valueOf(reader.readLine());
        Card firstCard = new Card(rankPower, suitPower);

        RankPower rankPower2 = RankPower.valueOf(reader.readLine());
        SuitPower suitPower2 = SuitPower.valueOf(reader.readLine());
        Card secondCard = new Card(rankPower2, suitPower2);

        if (firstCard.compareTo(secondCard) >= 0){
            System.out.println(firstCard);
        } else {
            System.out.println(secondCard);
        }


    }
}
