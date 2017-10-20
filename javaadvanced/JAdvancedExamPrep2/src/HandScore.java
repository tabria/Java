import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HandScore {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] sequenceInfo = new int[2];
        String sequenceSuit = "";

        String[] handCards = reader.readLine().split("\\s+");

        int sum = 0;
        for (int i = 0; i <handCards.length ; i++) {
            String currentCard = handCards[i];
            int handFaceValue = getCardFaceValue(currentCard);
            String handSuitValue = String.valueOf(currentCard.charAt(currentCard.length()-1));
            if (sequenceSuit.isEmpty()){
                sequenceSuit = handSuitValue;
                sequenceInfo[0] = 1;
                sequenceInfo[1] += handFaceValue;
            } else if (sequenceSuit.equals(handSuitValue)){
                sequenceInfo[0] +=1;
                sequenceInfo[1] +=handFaceValue;
            } else {
                sequenceSuit = handSuitValue;
                sum += sequenceInfo[1]*sequenceInfo[0];
                sequenceInfo[0] = 1;
                sequenceInfo[1] = handFaceValue;
            }
            if (i == handCards.length-1){
                sum += sequenceInfo[1]*sequenceInfo[0];
            }
        }

        System.out.println(sum);

    }

    private static int getCardFaceValue(String currentCard) {
        String number = String.valueOf(currentCard.charAt(0));
        switch(number) {
            case "1":
                number = "10";
                break;
            case "J":
                number = "12";
                break;
            case "Q":
                number = "13";
                break;
            case "K":
                number = "14";
                break;
            case "A":
                number = "15";
                break;
        }

        return Integer.parseInt(number);
    }

}
