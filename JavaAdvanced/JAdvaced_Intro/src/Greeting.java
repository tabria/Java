import java.util.Scanner;

public class Greeting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstString = scanner.nextLine();
        String secondString = scanner.nextLine();

        if (firstString.isEmpty()){
            firstString = "*****";
        }
        if (secondString.isEmpty()) {
            secondString = "*****";
        }

        System.out.printf("Hello, %s %s!", firstString, secondString);

    }
}
