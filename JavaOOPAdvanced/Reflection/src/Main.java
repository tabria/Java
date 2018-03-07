import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {


          Class<?> reflection = Reflection.class;
//
//        //Class<?> reflection2 = Class.forName("Reflection");
//        System.out.println(reflection);
//
//        Class<?> parent = reflection.getSuperclass();
//        System.out.println(parent);
//
//        Class<?>[] integfaces = reflection.getInterfaces();
//        for (Class<?> interf:integfaces) {
//            System.out.println(interf);
//        }
//
//        Reflection newRefl = (Reflection) reflection.newInstance();
//        System.out.println(newRefl);


        Method[] methods =  reflection.getDeclaredMethods();

        Method[] getMethods = Arrays.stream(methods).filter(e-> e.getName().startsWith("get")).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);

//        Arrays.stream(getMethods).forEach(e-> System.out.println(String.format("%s will return %s", e.getName(), e.getReturnType())));
//
       Method[] setMethods = Arrays.stream(methods).filter( e->e.getName().startsWith("set")).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);

//        Arrays.stream(setMethods).forEach(e-> System.out.println(String.format("%s and will set field of %s", e.getName(), e.getParameterTypes()[0])));

        Field[] fields = reflection.getDeclaredFields();
        Arrays.sort(fields, Comparator.comparing(Field::getName));

        for (Field field:fields) {
            if(!Modifier.isPrivate(field.getModifiers())){
                System.out.println(String.format("%s must be private!", field.getName()));
            }
        }

        for (Method method:getMethods) {
            if (!Modifier.isPublic(method.getModifiers())){
                System.out.println(String.format("%s have to be public!",method.getName()));
            }
        }

        for (Method method:setMethods) {
            if(!Modifier.isPrivate(method.getModifiers())){
                System.out.println(String.format("%s have to be private!", method.getName()));
            }
        }
    }

}
