package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<?> soil = RichSoilLand.class;
        Field[] fields = soil.getDeclaredFields();

        String line="";
        while (!"HARVEST".equals(line = reader.readLine())){
            for (Field field:fields) {
                switch(line){
                    case "private":
                        if (Modifier.isPrivate(field.getModifiers())){
                            printField(field);
                        }
                        break;
                    case "protected":
                        if (Modifier.isProtected(field.getModifiers())){
                            printField(field);
                        }
                        break;
                    case "public":
                        if (Modifier.isPublic(field.getModifiers())){
                            printField(field);
                        }
                        break;
                    case "all":
                        printField(field);
                        break;
                }
            }
        }

    }

    private static void printField(Field field) {
        System.out.println(String.format("%s %s %s",Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
    }
}