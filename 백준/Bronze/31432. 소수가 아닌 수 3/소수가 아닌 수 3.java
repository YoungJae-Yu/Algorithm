import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 9;
        while (st.hasMoreTokens()) {
            min = Math.min(min, Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("YES\n");
        if (min == 0 || min == 1) {
            sb.append(min);
        } else {
            sb.append(min).append(min).append(min);
        }
        System.out.print(sb);
    }
}