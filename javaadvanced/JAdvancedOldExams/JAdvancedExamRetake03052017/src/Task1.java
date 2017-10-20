import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Task1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] cards = br.readLine().split(" ");

        int sum = 0;
        int seqSum=0;
        for (int i = 0; i <cards.length ; i++) {
            String cardType = cards[i].substring(cards[i].length()-1);
            int cardValue = getCardValue(cards, i);
            int count = 1;
            for (int j = i+1; j <cards.length ; j++) {
                String cardTypeSeq = cards[j].substring(cards[j].length()-1);
                if (cardTypeSeq.equals(cardType)){
                    int cardValueSeq = getCardValue(cards, j);
                    seqSum += cardValueSeq;
                    count++;
                } else {
                    break;
                }
            }

            sum = sum + (cardValue + seqSum)*count;
            i = i+count-1;
            seqSum =0;
        }

        System.out.println(sum);

    }

    private static int getCardValue(String[] cards, int i) {
        String cardValue = cards[i].substring(0, cards[i].length()-1);
        switch (cardValue){
            case "J":
                cardValue = "12";
                break;
            case "Q":
                cardValue = "13";
                break;
            case "K":
                cardValue = "14";
                break;
            case "A":
                cardValue = "15";
                break;
        }
        return Integer.parseInt(cardValue);
    }

}
