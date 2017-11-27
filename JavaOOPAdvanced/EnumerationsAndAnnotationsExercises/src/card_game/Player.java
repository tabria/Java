package card_game;

public interface Player {

    String getName();

    Card getMaxCard();

    void addCard(Card card);
}
