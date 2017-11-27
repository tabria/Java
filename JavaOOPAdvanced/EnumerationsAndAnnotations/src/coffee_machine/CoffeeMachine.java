package coffee_machine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private List<Coffee> coffeesSold;
    private int coins;

    public CoffeeMachine() {
        this.coffeesSold = new ArrayList<>();
        this.coins = 0;
    }

    public int getCoins() {
        return coins;
    }

    public void insertCoin(String coin){
        Coin newCoin = Coin.valueOf(coin);
        this.coins += newCoin.getCoinValue();
    }

    public void buyCoffee(String inputSize, String inputType){
        CoffeeSize size = CoffeeSize.valueOf(inputSize.toUpperCase());
        CoffeeType type = CoffeeType.valueOf(inputType.toUpperCase());
        Coffee coffee = new Coffee(size, type);
        if (coffee.getSize().getPrice() <= this.getCoins() ){
            this.setCoins(0);
            this.coffeesSold.add(coffee);
        }
    }

    public Iterable<Coffee> coffeesSold(){
        return this.coffeesSold;
    }

    private void setCoins(int coins) {
        this.coins = coins;
    }
}
