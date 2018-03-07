package black_box_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    private static final String INNER_FIELD_NAME = "innerValue";

    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<?> peshoslav = BlackBoxInt.class;
        Constructor cons[] = peshoslav.getDeclaredConstructors();
        Object peshoslavObj = null;
        for (Constructor con:cons) {
            if (con.getParameterCount() == 0){
                con.setAccessible(true);
                peshoslavObj = con.newInstance();
            }
        }
        //Object peshoslavObj = peshoslav.newInstance();

        Method[] methods = peshoslav.getDeclaredMethods();

        String line="";
        while(!"END".equals(line = reader.readLine())){
            String[] command = line.split("_");
            for (Method method:methods) {
                if (method.getName().startsWith(command[0])){
                    method.setAccessible(true);
                    Object result = method.invoke(peshoslavObj, Integer.parseInt(command[1]));
                    printField(peshoslav, peshoslavObj);
                }
            }
        }
    }

    private static void printField(Class<?> peshoslav, Object peshoslavObj) throws IllegalAccessException {
        Field[] fields = peshoslav.getDeclaredFields();
        for (Field field:fields) {
            if (field.getName().equals(INNER_FIELD_NAME)){
                field.setAccessible(true);
                Object value =  field.get(peshoslavObj);
                System.out.println(value);
            }
        }
    }
}
