import java.io.*;
import java.util.Scanner;
/**
 * Created by arama on 10/13/2017.
 */
public class ExtractIntegers {

    public static void main(String[] args) {



        String input ="C:\\Users\\arama\\Desktop\\input.txt";
        String output = "C:\\Users\\arama\\Desktop\\output.txt";

        try(Scanner scanner = new Scanner(new FileInputStream(input));
            PrintWriter fileOutput = new PrintWriter(new FileOutputStream(output))) {
                while(scanner.hasNext()){
                    if(scanner.hasNextInt()){
                        fileOutput.println(scanner.nextInt());
                    }

                    scanner.next();
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
