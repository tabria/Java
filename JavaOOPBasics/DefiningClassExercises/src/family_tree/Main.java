package family_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> familyMembers = new LinkedList<>();
        List<Person> familyRelations = new LinkedList<>();


        String[] targetPersonData = reader.readLine().trim().split("\\s+");
        String targetName = targetPersonData.length>1 ? targetPersonData[0] + " " + targetPersonData[1] : "";
        String targetBirthday =  targetPersonData.length<2 ? targetPersonData[0] : "";


        while(true){
            String personRelation = reader.readLine();
            if ("End".equals(personRelation)){
                break;
            }
            String[] personsInfo = personRelation.split("\\s+-\\s+");
            if (personsInfo.length == 1){
                String[] personFullData = personsInfo[0].split("\\s+");
                String personFullName = personFullData[0] + " " + personFullData[1];
                String personFullBirthday = personFullData[2];
                familyMembers.add(new Person(personFullName, personFullBirthday));
            } else {
                Person newParent = new Person();
                if (personsInfo[0].contains("/")){
                    newParent.setBirthday(personsInfo[0]);
                } else {
                    newParent.setName(personsInfo[0]);
                }

                Person newChild = new Person();
                if (personsInfo[1].contains("/")){
                    newChild.setBirthday(personsInfo[1]);
                } else {
                    newChild.setName(personsInfo[1]);
                }
                newParent.addPersonChildrens(newChild);
                newChild.addPersonParents(newParent);
                familyRelations.add(newParent);
                familyRelations.add(newChild);
            }
        }

        for (Person person : familyMembers) {
            String personName = person.getName();
            String personBirthday = person.getBirthday();

                for (Person relative : familyRelations) {
                    if (personName.equals(relative.getName()) || personBirthday.equals(relative.getBirthday())){
                        for (Person parent:relative.getPersonParents()) {
                            person.addPersonParents(parent);
                        }
                        for (Person children:relative.getPersonChildrens()) {
                            person.addPersonChildrens(children);
                        }
                        relative.setName(person.getName());
                        relative.setBirthday(person.getBirthday());
                    }
                }

        }

        for (Person person : familyMembers) {
            if (person.getName().equals(targetName) || person.getBirthday().equals(targetBirthday)){
                System.out.println(person);
            }
        }
    }

}
