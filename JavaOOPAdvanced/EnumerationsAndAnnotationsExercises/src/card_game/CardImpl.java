package card_game;

public class CardImpl implements Card {

    private RankPower cardRank;
    private SuitPower cardSuite;

    public CardImpl(RankPower cardRank, SuitPower cardSuite) {
        this.setCardRank(cardRank);
        this.setCardSuite(cardSuite);
    }

    @Override
    public RankPower getCardRank() {
        return this.cardRank;
    }
    @Override
    public SuitPower getCardSuite() {
        return this.cardSuite;
    }

    private void setCardRank(RankPower cardRank) {
        this.cardRank = cardRank;
    }

    private void setCardSuite(SuitPower cardSuite) {
        this.cardSuite = cardSuite;
    }

    @Override
    public String toString() {
        int cardValue = this.cardRank.getRank() + this.cardSuite.getPower();
        return String.format("CardImpl name: %s of %s; CardImpl power: %d", this.cardRank.name(), this.cardSuite, cardValue );
    }
}
