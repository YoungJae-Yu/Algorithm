import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        TreeMap<Integer, Integer> chickens = new TreeMap<>();
        for (int i = 0; i < C; i++) {
            int t = Integer.parseInt(br.readLine().trim());
            chickens.put(t, chickens.getOrDefault(t, 0) + 1);
        }
        List<int[]> cows = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cows.add(new int[]{a, b});
        }
        cows.sort((x, y) -> {
            if (x[1] != y[1]) return Integer.compare(x[1], y[1]);
            return Integer.compare(x[0], y[0]);
        });
        int ans = 0;
        for (int[] cow : cows) {
            Integer key = chickens.ceilingKey(cow[0]);
            if (key != null && key <= cow[1]) {
                ans++;
                int cnt = chickens.get(key);
                if (cnt == 1) chickens.remove(key);
                else chickens.put(key, cnt - 1);
            }
        }
        System.out.println(ans);
    }
}