package coding_tracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    @Author(name = "Pesho")
    static void printMethodsByAuthor(Class<?> cl){
        Map<String, List<String>> authorsMethods = new HashMap<>();

        Method[] methods = cl.getDeclaredMethods();

        for (Method method:methods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation !=null){
                authorsMethods.putIfAbsent(annotation.name(), new ArrayList<>());
                authorsMethods.get(annotation.name()).add(method.getName() + "()");
            }
        }
        for (Map.Entry<String, List<String>> anno:authorsMethods.entrySet()) {
            System.out.printf("%s: ", anno.getKey());
            System.out.printf("%s%n", String.join(", ",anno.getValue()));
        }

    }
}
