import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dist = new int[F + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[S] = 0;
        q.add(S);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == G) break;
            int up = cur + U;
            if (up <= F && dist[up] == -1) {
                dist[up] = dist[cur] + 1;
                q.add(up);
            }
            int down = cur - D;
            if (down >= 1 && dist[down] == -1) {
                dist[down] = dist[cur] + 1;
                q.add(down);
            }
        }

        if (dist[G] == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(dist[G]);
        }
    }
}