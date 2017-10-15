import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by arama on 10/13/2017.
 */
public class WriteToFile {

    public static void main(String[] args) {

        String inputPath = "C:\\Users\\arama\\Desktop\\input.txt";
        String outputPath = "C:\\Users\\arama\\Desktop\\output.txt";
        List<Character> skip = new ArrayList<>();
        Collections.addAll(skip, ',','.', '!', '?');

        try(FileInputStream fileStream = new FileInputStream(inputPath);
                FileOutputStream outputStream = new FileOutputStream(outputPath)) {
            int oneByte = fileStream.read();
            while(oneByte>=0){
                char currentChar = (char) oneByte;
                if (!skip.contains(currentChar)){
                    outputStream.write(oneByte);
                }
                oneByte = fileStream.read();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
