package cat_lady;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Cat> cats = new ArrayList<>();

        while(true){
            String[] catInfo = reader.readLine().split("\\s+");
            if ("End".equals(catInfo[0])){
                break;
            }
            switch(catInfo[0]){
                case "Siamese":
                    cats.add(new Siamese(catInfo[1], Double.parseDouble(catInfo[2])));

                    break;
                case "Cymric":
                    cats.add(new Cymric(catInfo[1], Double.parseDouble(catInfo[2])));
                    break;
                case "StreetExtraordinaire":
                    cats.add(new StreetExtraordinaire(catInfo[1], Double.parseDouble(catInfo[2])));
                    break;
            }
        }

        String catToPrint = reader.readLine();

        cats.stream().filter(x-> x.getName().equals(catToPrint)).forEach(System.out::println);

    }

}
