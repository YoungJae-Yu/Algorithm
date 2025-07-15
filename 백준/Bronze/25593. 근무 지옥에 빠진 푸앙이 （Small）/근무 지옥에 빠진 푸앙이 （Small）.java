import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> work = new HashMap<>();
        int[] hours = {4, 6, 4, 10};

        while (N-- > 0) {
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 7; j++) {
                    String name = st.nextToken();
                    if (!name.equals("-")) {
                        work.put(name, work.getOrDefault(name, 0) + hours[i]);
                    }
                }
            }
        }

        if (work.isEmpty()) {
            System.out.println("Yes");
            return;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int t : work.values()) {
            if (t < min) min = t;
            if (t > max) max = t;
        }

        System.out.println((max - min) > 12 ? "No" : "Yes");
    }
}