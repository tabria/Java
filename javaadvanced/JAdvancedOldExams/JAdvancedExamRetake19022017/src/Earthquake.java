import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Earthquake {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Deque<Integer>> sequences = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int[] count = new int[1];
        boolean isSeismicity = true;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <n ; i++) {
            Deque<Integer> waves = new ArrayDeque<>();
            getWaves(waves, br);
            quake(waves, sequences, sb, isSeismicity, count);
            isSeismicity = true;

        }
        while (sequences.size()>0){
            Deque<Integer> waves = sequences.poll();
            quake(waves, sequences, sb, isSeismicity, count);
            isSeismicity = true;
        }

        System.out.println(count[0]);
        System.out.println(sb.toString());
    }

    private static void getWaves(Deque<Integer> waves, BufferedReader br) throws IOException {
        String[] rawWaves = br.readLine().split(" ");
        for (int j = 0; j <rawWaves.length ; j++) {
            waves.offer(Integer.parseInt(rawWaves[j]));
        }
    }
    private static void quake(Deque<Integer> waves, Deque<Deque<Integer>> sequences, StringBuilder sb, boolean isSeismicity, int[] count) {
        int seismicity = waves.poll();
        Deque<Integer> sequenceLeft = new ArrayDeque<>();
        while(waves.size()>0){
            if (!isSeismicity){
                break;
            }
            int currentWave = waves.peek();
            if (currentWave > seismicity && isSeismicity){
                sb.append(seismicity)
                        .append(" ");
                count[0] +=1;
                isSeismicity = false;
            } else {
                waves.poll();
            }
        }
        if (waves.size()>0){
            sequences.offer(waves);
        } else {
            sb.append(seismicity)
                    .append(" ");
            count[0] +=1;
        }

    }
}

