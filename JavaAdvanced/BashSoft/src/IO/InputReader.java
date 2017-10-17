package IO;

import StaticData.SessionData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputReader {

    private static final String END_COMMAND = "quit";

    public static void readCommands() throws IOException, InterruptedException {

        OutputWriter.writeMessage(String.format("%s >", SessionData.currentPath));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();

        while(!END_COMMAND.equals(input)){

            CommandInterpreter.interpretCommand(input);
            OutputWriter.writeMessage(String.format("%s >", SessionData.currentPath));

            input = reader.readLine().trim();
        }

        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);
        for (Thread thread : threads) {
            if (!thread.getName().equals("main") && !thread.isDaemon()) {
                thread.join();
            }
        }

    }

}
