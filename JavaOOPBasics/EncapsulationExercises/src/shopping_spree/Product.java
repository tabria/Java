package shopping_spree;

import java.util.List;

public class Product {

    private String name;
    private double cost;


    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    String getName() {
        return this.name;
    }

    private void setName(String name) throws IllegalArgumentException{
        if (name.isEmpty()|| name == null || name.matches("\\s+")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    double getCost() {
        return this.cost;
    }

    private void setCost(double cost)  {
        if (cost < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    @Override
    public String toString() {
        return name ;
    }
}



