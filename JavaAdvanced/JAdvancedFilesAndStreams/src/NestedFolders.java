import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by arama on 10/13/2017.
 */
public class NestedFolders {

    public static void main(String[] args) {

        String folder = "C:\\Users\\arama\\Desktop\\Files-and-Streams";
        Deque<File> queue = new ArrayDeque<>();
        File root = new File(folder);

        queue.offer(root);
        int count =0;
        while(queue.size()>0){
            File current = queue.poll();
            System.out.println(current.getName());
            count++;

            for (File dr : current.listFiles()) {
                if(dr.isDirectory()){
                    queue.offer(dr);
                }
            }
        }
        System.out.println(count + " folders");



    }

}
