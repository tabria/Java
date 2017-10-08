import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] invitesInput = scanner.nextLine().split(" ");
        LinkedList<String> invites = new LinkedList<>(Arrays.asList(invitesInput));

        Predicate<String> isParty = party -> party.equalsIgnoreCase("party!");
        Predicate<String> isRemove = rem -> rem.equalsIgnoreCase("remove");
        Predicate<String> isLength = len ->len.equalsIgnoreCase("length");
        Predicate<String> isStart = start ->start.equalsIgnoreCase("startswith");


        while(true){
            String[] commands = scanner.nextLine().split(" ");
            if (isParty.test(commands[0])){
                break;
            }

            String secondCommand = commands[1];
            if(isRemove.test(commands[0])){
                if (isLength.test(secondCommand)) {
                    removeLength(invites, secondCommand, commands[2]);
                } else {
                    removeWith(invites, isStart, secondCommand, commands[2]);
                }
            } else {
                if (isLength.test(secondCommand)) {
                    doubleLength(invites, secondCommand, commands[2]);
                } else {
                    doubleWith(invites, isStart, secondCommand, commands[2]);
                }
            }
         }
        StringBuilder sb = new StringBuilder();
         if (invites.size()>0){

             for (String entry : invites) {
                 sb.append(entry)
                         .append(", ");
             }
             sb.delete(sb.length()-2, sb.length());
             sb.append(" are going to the party!");
         } else {
             sb.append("Nobody is going to the party!");
         }
        System.out.println(sb.toString());

    }

    private static void doubleLength(LinkedList<String> invites, String secondCommand, String length) {
        int len = Integer.parseInt(length);
        for (int i = 0; i <invites.size() ; i++) {
            String name = invites.get(i);
            if (name.length() == len){
                invites.add(invites.indexOf(name)+1, name);
                i++;
            }
        }
    }
    private static void removeLength(LinkedList<String> invites, String secondCommand, String length) {
        int len = Integer.parseInt(length);
        for (int i = 0; i <invites.size() ; i++) {
            String name = invites.get(i);
            if (name.length() == len){
                invites.remove(name);
                i--;
            }
        }
    }

    private static void doubleWith(LinkedList<String> invites, Predicate<String> isStart, String secondCommand, String marker) {
        if (isStart.test(secondCommand)){
            for (int i = 0; i <invites.size() ; i++) {
                String name = invites.get(i);
                if (name.substring(0, marker.length()).equals(marker)){
                    invites.add(invites.indexOf(name)+1, name);
                    i++;
                }
            }
        } else {
            for (int i = 0; i <invites.size() ; i++) {
                String name = invites.get(i);
                if (name.substring(name.length() - marker.length()).equals(marker)){
                    invites.add(invites.indexOf(name)+1, name);
                    i++;
                }
            }
        }
    }

    private static void removeWith(LinkedList<String> invites, Predicate<String> isStart, String secondCommand, String marker) {

        if (isStart.test(secondCommand)){
            invites.removeIf(y -> y.substring(0, marker.length()).equals(marker));
            //invites.removeIf((string) -> (string).startsWith(marker));
        } else {
            invites.removeIf(y -> y.substring(y.length() - marker.length()).equals(marker));
            //invites.removeIf((string) -> (string).endsWith(marker));
        }

    }

}
