import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;


class Person {

    private String name;
    private int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return this.group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
public class GroupByGroup {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> peoples = new ArrayList<>();

        while(true){
            String inputDude = scanner.nextLine();
            if ("END".equals(inputDude)){
                break;
            }
            int lastSpaceIndex = inputDude.lastIndexOf(" ");
            String inputDudeName = inputDude.substring(0, lastSpaceIndex);
            int inputDudeGroup = Integer.valueOf(inputDude.substring(lastSpaceIndex+1));
            Person dude = new Person(inputDudeName, inputDudeGroup);
            peoples.add(dude);
        }

        Map<Integer, List<Person>> groupByGroup = peoples.stream().collect(Collectors.groupingBy(Person::getGroup));
        groupByGroup.entrySet().stream().forEach(print());
    }

    private static Consumer<Map.Entry<Integer,List<Person>>> print() {
        return kv->{
            System.out.print(kv.getKey() + " - ");
            StringBuilder sb = new StringBuilder();
            for (Person pep : kv.getValue()) {
                sb.append(pep.getName().toString());
                sb.append(", ");
            }
            sb.delete(sb.length()-2, sb.length());
            System.out.println(sb.toString());
        };
    }
}
