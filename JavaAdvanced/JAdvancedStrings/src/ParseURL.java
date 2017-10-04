import java.util.Scanner;
public class ParseURL {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("://");

        if (text.length == 2){
            String protocol = text[0];

            int indexServer = text[1].indexOf('/');
            String server = text[1].substring(0, indexServer);

            String resources = text[1].substring(indexServer + 1);


            System.out.println("Protocol = " + protocol);
            System.out.println("Server = " + server);
            System.out.println("Resources = " + resources);
        } else {
            System.out.println("Invalid URL");
        }


    }

}
