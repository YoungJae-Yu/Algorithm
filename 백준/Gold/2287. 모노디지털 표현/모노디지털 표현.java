import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());

        List<Set<Long>> dp = new ArrayList<>();
        dp.add(new HashSet<>());

        Map<Long, Integer> best = new HashMap<>();

        long concat = 0;
        for (int i = 1; i <= 8; i++) {
            concat = concat * 10 + k;
            Set<Long> cur = new HashSet<>();
            cur.add(concat);

            for (int j = 1; j < i; j++) {
                Set<Long> left = dp.get(j);
                Set<Long> right = dp.get(i - j);

                for (long a : left) {
                    for (long b : right) {
                        cur.add(a + b);
                        cur.add(a - b);
                        cur.add(b - a);
                        cur.add(a * b);
                        if (b != 0) cur.add(a / b);
                        if (a != 0) cur.add(b / a);
                    }
                }
            }

            dp.add(cur);
            for (long v : cur) {
                best.putIfAbsent(v, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long target = Long.parseLong(br.readLine().trim());
            Integer ans = best.get(target);
            sb.append(ans == null ? "NO" : ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}