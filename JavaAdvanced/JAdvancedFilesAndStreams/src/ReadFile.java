import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {

        String path = "C:\\Users\\arama\\Desktop\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path);) {
            int oneByte = fileStream.read();
            while(oneByte >=0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
