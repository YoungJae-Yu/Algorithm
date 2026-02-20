import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;

public class Main {
    static class Stud implements Comparable<Stud> {
        int h, k;
        Stud(int h, int k) { this.h = h; this.k = k; }
        @Override
        public int compareTo(Stud o) {
            return Integer.compare(o.h, this.h); // 내림차순
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stud[] arr = new Stud[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr[i] = new Stud(h, k);
        }

        Arrays.sort(arr);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Stud s : arr) {
            Integer key = map.lowerKey(s.k);
            if (key == null) {
                map.put(1, map.getOrDefault(1, 0) + 1);
            } else {
                int cnt = map.get(key);
                if (cnt == 1) map.remove(key);
                else map.put(key, cnt - 1);

                int nk = key + 1;
                map.put(nk, map.getOrDefault(nk, 0) + 1);
            }
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            ans += e.getValue();
        }
        System.out.print(ans);
    }
}