import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(2);
        while (true) {
            int s = fib.size();
            long nxt = (long)fib.get(s-1) + fib.get(s-2);
            if (nxt > 1000000000L) break;
            fib.add((int)nxt);
        }
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> used = new ArrayList<>();
            for (int i = fib.size() - 1; i >= 0 && n > 0; i--) {
                if (fib.get(i) <= n) {
                    used.add(fib.get(i));
                    n -= fib.get(i);
                }
            }
            Collections.sort(used);
            for (int i = 0; i < used.size(); i++) {
                if (i > 0) sb.append(' ');
                sb.append(used.get(i));
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}