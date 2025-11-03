import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int t = 0; t < 4; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());
            char ans;
            if (x2 < x3 || x4 < x1 || y2 < y3 || y4 < y1) ans = 'd';
            else if ((x2 == x3 && (y2 == y3 || y1 == y4)) || (x1 == x4 && (y2 == y3 || y1 == y4))) ans = 'c';
            else if (x2 == x3 || x1 == x4 || y2 == y3 || y1 == y4) ans = 'b';
            else ans = 'a';
            System.out.println(ans);
        }
    }
}