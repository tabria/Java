import java.util.HashMap;
import java.util.Scanner;
public class PhoneBook {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phoneBook = new HashMap<>();

        while(true){
            String[] personPhone = scanner.next().split("-");
            if (personPhone[0].equals("search")){
                break;
            }
            phoneBook.put(personPhone[0], personPhone[1]);
        }
        while(true){
            String person = scanner.nextLine();
            if (person.isEmpty()){
                continue;
            }
            if (person.equals("stop")){
                break;
            }
            if (phoneBook.containsKey(person)){
                System.out.println(person + " -> " + phoneBook.get(person) );

            } else {
                System.out.println("Contact " + person + " does not exist.");
            }
        }

    }
}
