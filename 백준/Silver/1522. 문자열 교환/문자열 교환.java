import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = s.length();
        int totalA = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == 'a') totalA++;
        if (totalA == 0 || totalA == n) {
            System.out.println(0);
            return;
        }
        String ss = s + s;
        int k = totalA;
        int bCount = 0;
        for (int i = 0; i < k; i++) if (ss.charAt(i) == 'b') bCount++;
        int min = bCount;
        for (int i = k; i < n + k; i++) {
            if (ss.charAt(i) == 'b') bCount++;
            if (ss.charAt(i - k) == 'b') bCount--;
            if (bCount < min) min = bCount;
        }
        System.out.println(min);
    }
}