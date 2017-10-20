import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        Deque<BigDecimal> queueDigits = new ArrayDeque<>();
        Deque<BigDecimal> queueOperators = new ArrayDeque<>();

        fillQueueDigits(queueDigits, text);
        addOperators(queueDigits, queueOperators, text);
        BigDecimal result = sumNumbers(queueOperators);

        DecimalFormat df = new DecimalFormat("#.#######");
        System.out.println(df.format(result));
    }

    private static BigDecimal sumNumbers(Deque<BigDecimal> queueOperators) {
        BigDecimal sum = BigDecimal.valueOf(0);
        while (queueOperators.size()>0){
            sum = sum.add(queueOperators.poll());
        }
        return sum;
    }

    private static void addOperators(Deque<BigDecimal> queueDigits, Deque<BigDecimal> queueOperators, String text) {
        //Pattern pattern = Pattern.compile("([^\\d.]+)");
        Pattern pattern = Pattern.compile("((?!\\d*\\.?\\d+).)+");
        Matcher matcher = pattern.matcher(text);
        queueOperators.offer(queueDigits.poll());
        while (matcher.find() && queueDigits.size()>0){
            String a = matcher.group();
            long size = matcher.group().length();
            if (size % 2 == 0){
                queueOperators.offer(queueDigits.poll());
            } else {
                queueOperators.offer(queueDigits.poll().multiply(BigDecimal.valueOf(-1)));
            }
        }
    }

    private static void fillQueueDigits(Deque<BigDecimal> queueDigits, String text) {
        Pattern digitPattern = Pattern.compile("(\\d*[.]?\\d+)");
        Matcher matcher = digitPattern.matcher(text);
        while (matcher.find()){
            queueDigits.offer(new BigDecimal(matcher.group(1)));
        }
    }
}
