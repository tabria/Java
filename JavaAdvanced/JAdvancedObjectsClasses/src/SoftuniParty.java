import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftuniParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> party = new TreeSet<>();

        boolean list = true;
        while(true){
            String text = scanner.nextLine();

            if (text.equals("END")){
                break;
            }
            if (text.equals("PARTY")){
                list = false;
                continue;
            }
            if (list) {
                party.add(text);
            } else {
                party.remove(text);
            }
        }

        System.out.println(party.size());
        for (String s : party) {
            System.out.println(s);
        }
    }



}
