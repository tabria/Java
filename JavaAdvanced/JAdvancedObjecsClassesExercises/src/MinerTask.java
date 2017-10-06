import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class MinerTask {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Long> resources = new HashMap<>();

        int count =1;
        String name = "";
        while(true){
            String input = scanner.nextLine();
            if (input.equals("stop")){
                break;
            }
            if (count % 2 != 0){
                name = input;
            } else {
                long quantity = Long.parseLong(input);
                if (resources.containsKey(name)){
                    quantity += resources.get(name);
                }
                resources.put(name, quantity);
            }
            count++;
        }

        for (Map.Entry<String, Long> resource : resources.entrySet()) {
            System.out.println(resource.getKey() + " -> " + resource.getValue() );
        }

    }

}
