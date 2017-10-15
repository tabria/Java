import java.io.*;
import java.util.Scanner;
public class WriteEveryThirdLine {

    public static void main(String[] args) {

        String input ="C:\\Users\\arama\\Desktop\\input.txt";
        String output = "C:\\Users\\arama\\Desktop\\output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(input));
             PrintWriter printer = new PrintWriter(new FileWriter(output))){

            int count =1;
            String line = br.readLine();
            while(line != null){
                if (count % 3 == 0){
                    printer.println(line);
                }
                count++;
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
