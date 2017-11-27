package card_game;

import java.util.HashMap;
import java.util.Map;

public class PlayerImpl implements Player {

    private String name;
    private Map<Integer, Card> playerCards;

    public PlayerImpl(String name) {
        this.name = name;
        this.playerCards = new HashMap<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Card getMaxCard(){
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Card> currentCard:this.playerCards.entrySet()) {
            if (max < currentCard.getKey()){
                max = currentCard.getKey();
            }
        }

        return this.playerCards.get(max);
    }


    @Override
    public void addCard(Card card){
        int rank = card.getCardRank().getRank() + card.getCardSuite().getPower();
        this.playerCards.put(rank, card);
    }


}
