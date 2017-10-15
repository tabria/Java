import java.io.*;

public class CopyBytes {

    public static void main(String[] args) {

        String input ="C:\\Users\\arama\\Desktop\\input.txt";
        String output = "C:\\Users\\arama\\Desktop\\output.txt";

        try (InputStream fileStream = new FileInputStream(input);
             OutputStream fileOutput = new FileOutputStream(output)) {
            int oneByte = fileStream.read();
            while(oneByte >=0){

                if (oneByte == 10 || oneByte == 32){
                    fileOutput.write(oneByte);
                } else {
                    String digit = String.valueOf(oneByte);
                    for (int i = 0; i <digit.length() ; i++) {
                        fileOutput.write(digit.charAt(i));
                    }
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
