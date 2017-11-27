package card_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Card> dealCards = new ArrayList<>();

        Player one = new PlayerImpl(reader.readLine());
        Player two = new PlayerImpl(reader.readLine());

        int countCards = 0;
        while(countCards < 10){
            String[] currentCard = reader.readLine().split("\\s+of\\s+");
            try {
                RankPower rankPower = RankPower.valueOf(currentCard[0]);
                SuitPower suitPower = SuitPower.valueOf(currentCard[1]);
                Card newCard = new CardImpl(rankPower , suitPower);

                boolean isNotInDeck = false;
                for (Card card:dealCards) {
                    if (card.getCardRank().name().equals(rankPower.name()) && card.getCardSuite().name().equals(suitPower.name())) {
                        System.out.println("Card is not in the deck.");
                        isNotInDeck = true;
                    }
                }
                if (!isNotInDeck){
                    countCards++;
                    dealCards.add(newCard);
                    if (countCards <= 5){
                        one.addCard(newCard);
                    } else {
                        two.addCard(newCard);
                    }
                }
            } catch (Exception e){
                System.out.println("No such card exists.");
            }
        }

        Card oneBestCard = one.getMaxCard();
        int oneBestRank = oneBestCard.getCardRank().getRank() + oneBestCard.getCardSuite().getPower();
        Card twoBestCard = two.getMaxCard();
        int twoBestRank = twoBestCard.getCardRank().getRank() +  twoBestCard.getCardSuite().getPower();
        if (oneBestRank >= twoBestRank){
            System.out.printf("%s wins with %s of %s.", one.getName(), oneBestCard.getCardRank().name(), oneBestCard.getCardSuite().name() );
        } else {
            System.out.printf("%s wins with %s of %s.", two.getName(), twoBestCard.getCardRank().name(), twoBestCard.getCardSuite().name() );
        }

    }

}

