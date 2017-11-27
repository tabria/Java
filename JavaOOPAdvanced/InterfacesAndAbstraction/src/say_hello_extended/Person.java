package say_hello_extended;

public interface Person {


    String getName();
    default String sayHello() {
        return "Hello";
    }

}
