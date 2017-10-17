package Judge;

import IO.OutputWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static void compareContent(String actualOutput, String expectedOutput) {
        OutputWriter.writeMessageOnNewLine("Reading files...");
        String mismatchPath = getMismatchPath(expectedOutput);

        List<String> actualOutputString = readTextFile(actualOutput);
        List<String> expectedOutputString = readTextFile(expectedOutput);

        boolean mismatch = compareStrings(actualOutputString, expectedOutputString, mismatchPath);

    }

    private static boolean compareStrings(List<String> actualOutputString, List<String> expectedOutputString, String mismatchPath) {
        OutputWriter.writeMessageOnNewLine("Comparing files...");
        String output = "";
        boolean isMismatch = false;

        try (FileWriter fileWriter = new FileWriter(mismatchPath);
                BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (int i = 0; i < expectedOutputString.size() ; i++) {
                String lineActualOutput = actualOutputString.get(i);
                String lineExpectedOutput = expectedOutputString.get(i);

                if (!lineActualOutput.equals(lineExpectedOutput)){
                    isMismatch = true;
                    output = String.format("mismatch -> expected(%s), actual(%s)%n", lineExpectedOutput, lineActualOutput);
                } else {
                    output = String.format("line match -> %s%n", lineActualOutput);
                }

                writer.write(output);
            }

            writer.close();
        } catch (IOException e) {
            OutputWriter.displayException("Error.");
        }

        if (isMismatch){
            List<String> mismatchString = readTextFile(mismatchPath);
            mismatchString.forEach(OutputWriter::writeMessageOnNewLine);
        } else {
            OutputWriter.writeMessageOnNewLine("Files are identical. There are no mismatches");
        }

        return isMismatch;
    }

    private static List<String> readTextFile(String filePath) {
        List<String> text = new ArrayList<>();

        File file = new File(filePath);

        try ( FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line != null){
                text.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            OutputWriter.writeMessageOnNewLine("File not found");
        }

        return text;
    }

    public static String getMismatchPath(String expectedOutput) {
        int index = expectedOutput.lastIndexOf('\\');
        String directoryPath = expectedOutput.substring(0, index);
        return directoryPath + "\\mismatch.txt";
    }


}
