import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine());
            HashSet<Integer> students = new HashSet<>();
            for (int i = 0; i < K; i++) {
                students.add(Integer.parseInt(st.nextToken()));
            }
            int N = Integer.parseInt(br.readLine().trim());
            int bestNum = 0;
            int bestTime = Integer.MAX_VALUE;
            int passCnt = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int hour = Integer.parseInt(st.nextToken());
                int minute = Integer.parseInt(st.nextToken());
                if (!students.contains(num)) continue;
                if (hour == -1 && minute == -1) continue;
                int time = hour * 60 + minute;
                if (time <= 360) {
                    passCnt++;
                    if (time < bestTime) {
                        bestTime = time;
                        bestNum = num;
                    }
                }
            }
            sb.append(bestNum).append(" ").append(passCnt).append("\n");
        }
        System.out.print(sb.toString());
    }
}