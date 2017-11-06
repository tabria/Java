package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            try {
                String animalType = reader.readLine();
                if ("Beast!".equals(animalType)){
                    break;
                }
                String[] animalInfo = reader.readLine().split("\\s+");
                if (animalInfo.length!=3){
                    throw new IllegalArgumentException("Invalid input!");
                }
                switch(animalType.toLowerCase()){
                    case "cat":
                        Cat newCat = new Cat(animalInfo[0], animalInfo[1], animalInfo[2]);
                        System.out.println(newCat);
                        break;
                    case "dog":
                        Dog newDog = new Dog(animalInfo[0], animalInfo[1], animalInfo[2]);
                        System.out.println(newDog);
                        break;
                    case "frog":
                        Frog newFrog = new Frog(animalInfo[0], animalInfo[1], animalInfo[2]);
                        System.out.println(newFrog);
                        break;
                    case "kitten":
                        Kitten newKitten = new Kitten(animalInfo[0], animalInfo[1], animalInfo[2]);
                        System.out.println(newKitten);
                        break;
                    case "tomcat":
                        Tomcat newTomcat = new Tomcat(animalInfo[0], animalInfo[1], animalInfo[2]);
                        System.out.println(newTomcat);
                        break;
                        default:

                            throw new IllegalArgumentException("Invalid input!");
                }
            } catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }
    }

}
