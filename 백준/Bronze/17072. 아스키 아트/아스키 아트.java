import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int R = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int intensity = 2126 * R + 7152 * G + 722 * B;
                if (intensity < 510000) sb.append('#');
                else if (intensity < 1020000) sb.append('o');
                else if (intensity < 1530000) sb.append('+');
                else if (intensity < 2040000) sb.append('-');
                else sb.append('.');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}