import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by arama on 10/13/2017.
 */
public class ListFiles {

    public static void main(String[] args) {

        String folder = "C:\\Users\\arama\\Desktop\\Files-and-Streams";

        File file = new File(folder);
        if (file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for ( File fi: files) {
                    if (!fi.isDirectory()){
                        System.out.println(fi.getName() + ": " + fi.length());
                    }
                }
            }
        }


    }


}
