import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] trucks = new int[N];
        for (int i = 0; i < N; i++) trucks[i] = Integer.parseInt(st.nextToken());
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < W; i++) bridge.add(0);
        int time = 0;
        int curWeight = 0;
        int idx = 0;
        while (idx < N) {
            time++;
            curWeight -= bridge.poll();
            int next = trucks[idx];
            if (curWeight + next <= L) {
                bridge.add(next);
                curWeight += next;
                idx++;
            } else {
                bridge.add(0);
            }
        }
        while (!bridge.isEmpty()) {
            time++;
            curWeight -= bridge.poll();
        }
        System.out.println(time);
    }
}