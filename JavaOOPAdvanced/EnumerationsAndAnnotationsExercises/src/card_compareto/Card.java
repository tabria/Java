package card_compareto;

public class Card implements Comparable<Card> {

    private RankPower cardRank;
    private SuitPower cardSuite;

    public Card(RankPower cardRank, SuitPower cardSuite) {
        this.cardRank = cardRank;
        this.cardSuite = cardSuite;
    }

    @Override
    public String toString() {
        int cardValue = this.cardRank.getRank() + this.cardSuite.getPower();
        return String.format("CardImpl name: %s of %s; CardImpl power: %d", this.cardRank.name(), this.cardSuite, cardValue );
    }

    @Override
    public int compareTo(Card o) {
        int firstCardPower = this.cardRank.getRank() + this.cardSuite.getPower();
        int secondCardPower = o.cardRank.getRank() + o.cardSuite.getPower();
        return firstCardPower - secondCardPower;
    }
}
