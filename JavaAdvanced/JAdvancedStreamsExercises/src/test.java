/**
 * Created by arama on 10/13/2017.
 */
import java.util.*;
public class test {


        public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);

            List<String> listPeople = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

            String commands = scanner.nextLine();

            while (!commands.contains("Party!")) {

                String command = commands.split("[ ]+")[0];
                String option = commands.split("[ ]+")[1];
                String criteria = commands.split("[ ]+")[2];

                performAction(command, option, criteria, listPeople);

                commands = scanner.nextLine();
            }

            printListPeople(listPeople);
        }

        private static List<String> selectPeople(String option, String criteria, List<String> listPeople) {

            List<String> names = new ArrayList<>();

            for (int i = 0; i < listPeople.size(); i++) {

                String name = listPeople.get(i);

                if (option.equals("StartsWith")) {
                    if (name.startsWith(criteria)) {
                        names.add(name);
                    }
                } else if (option.equals("EndsWith")) {
                    if (name.endsWith(criteria)) {
                        names.add(name);
                    }
                } else if (option.equals("Length")) {

                    int c = Integer.parseInt(criteria);
                    if (name.length() == c) {

                        names.add(name);
                    }
                }
            }
            return names;
        }

        private static void performAction(String command, String option, String criteria, List<String> listPeople) {

            List<String> selectPeoples = selectPeople(option, criteria, listPeople);

            if (command.equals("Remove")) {

                listPeople.removeAll(selectPeoples);

            } else if (command.equals("Double")) {

                listPeople.addAll(selectPeoples);
            }

        }

        private static void printListPeople(List<String> listPeople) {

            if (listPeople.size() == 0 || listPeople.get(0).equals("")) {

                System.out.println("Nobody is going to the party!");
            } else {

                Collections.sort(listPeople);

                String s = String.join(", ", listPeople);

                System.out.println(s + " are going to the party!");
            }
        }

}
