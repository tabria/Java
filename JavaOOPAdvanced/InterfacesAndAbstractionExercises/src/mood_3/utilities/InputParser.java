package mood_3.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {

    public List<String> parseBySpace (String input){
        return new ArrayList<>(Arrays.asList(input.split(" \\| ")));
    }

}
