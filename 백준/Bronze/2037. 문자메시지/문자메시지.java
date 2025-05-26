import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        String[] keys = {
            "", "", "ABC", "DEF", "GHI", 
            "JKL", "MNO", "PQRS", "TUV", "WXYZ"
        };
        int[][] map = new int[26][2];
        for (int i = 2; i <= 9; i++) {
            for (int j = 0; j < keys[i].length(); j++) {
                char c = keys[i].charAt(j);
                map[c - 'A'][0] = i;
                map[c - 'A'][1] = j + 1;
            }
        }

        int lastKey = 0;
        int totalTime = 0;
        for (char c : s.toCharArray()) {
            int key, cnt;
            if (c == ' ') {
                key = 1;
                cnt = 1;
            } else {
                key = map[c - 'A'][0];
                cnt = map[c - 'A'][1];
            }
            if (key == lastKey && c != ' ') {
                totalTime += w;
            }
            totalTime += cnt * p;
            lastKey = key;
        }

        System.out.println(totalTime);
    }
}