package shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> shoppers = new LinkedList<>();
        Map<String, Product> availableProduct = new HashMap<>();


        try {
            String[] users = reader.readLine().split(";");
            for (String user : users) {
                String[] userInfo = user.split("=");
                Person newPerson = new Person(userInfo[0], Double.parseDouble(userInfo[1]));
                shoppers.add(newPerson);
            }

            String[] products = reader.readLine().split(";");
            for (String prod : products) {
                String[] productInfo = prod.split("=");
                availableProduct.put(productInfo[0], new Product(productInfo[0], Double.parseDouble(productInfo[1])));
            }

            while(true) {
                String[] currentUser = reader.readLine().split("\\s+");
                if ("END".equals(currentUser[0])) {
                    break;
                }
                for (Person person : shoppers) {
                    if (person.getName().equals(currentUser[0])) {
                        person.addProduct(availableProduct.get(currentUser[1]));
                    }
                }
            }
            for (Person person:shoppers) {
                System.out.println(person);
            }

        }catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

}
