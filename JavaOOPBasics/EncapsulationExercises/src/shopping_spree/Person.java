package shopping_spree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> bag;


    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.bag = new LinkedList<>();
    }

    private void setName(String name) throws IllegalArgumentException{
        if (name.isEmpty() || name == null || name.matches("\\s+")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    double getMoney() {
        return this.money;
    }

    private void setMoney(double money)  {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<Product> getBag() {
        return Collections.unmodifiableList(this.bag);
    }

    void setBag(Product product) {
        this.bag.add(product);
    }

    void addProduct(Product product){
        if (product.getCost() > getMoney()){
            System.out.printf("%s can't afford %s\n", getName(), product.getName());
            return;
        }
        System.out.printf("%s bought %s\n", getName(), product.getName());
        setMoney(getMoney() - product.getCost());
        setBag(product);
    }

    @Override
    public String toString() {
        return getName() + " - " + printProducts(this.bag);
    }

    private String printProducts(List<Product> productsBag) {
        if (productsBag.size()<1){
            return "Nothing bought";
        } else {
            return productsBag.toString()
                    .replace("[", "")
                    .replace("]", "");
        }
    }



}
