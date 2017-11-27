package warning_levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Importance importanceLevel =  Importance.valueOf(reader.readLine());
        Logger newLogger = new Logger(importanceLevel);

        String line ="";
        while (!"END".equals(line = reader.readLine())){
            String[] messages = line.split(":\\s+");
            Message message = new Message(Importance.valueOf(messages[0]), messages[1]);
            newLogger.addMessage(message);
        }

        newLogger.getMessages().forEach(System.out::println);

    }

}
