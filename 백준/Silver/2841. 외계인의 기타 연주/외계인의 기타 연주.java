import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer>[] stacks = new ArrayDeque[7];
        for (int i = 1; i <= 6; i++) stacks[i] = new ArrayDeque<>();
        long moves = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            while (!stacks[s].isEmpty() && stacks[s].peek() > f) {
                stacks[s].pop();
                moves++;
            }
            if (f != 0 && (stacks[s].isEmpty() || stacks[s].peek() < f)) {
                stacks[s].push(f);
                moves++;
            }
        }
        System.out.println(moves);
    }
}