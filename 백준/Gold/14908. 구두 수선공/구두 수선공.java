import java.io.*;
import java.util.*;

public class Main {
    static class Job {
        int idx;
        int t;
        int s;
        Job(int idx, int t, int s) {
            this.idx = idx;
            this.t = t;
            this.s = s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        Job[] arr = new Job[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[i] = new Job(i + 1, t, s);
        }
        Arrays.sort(arr, new Comparator<Job>() {
            public int compare(Job a, Job b) {
                long left = (long)a.t * b.s;
                long right = (long)b.t * a.s;
                if (left < right) return -1;
                else if (left > right) return 1;
                else return Integer.compare(a.idx, b.idx);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(arr[i].idx);
        }
        System.out.println(sb.toString());
    }
}