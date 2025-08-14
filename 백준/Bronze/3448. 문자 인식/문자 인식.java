import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int r = 0;
            int a = 0;
            while (true) {
                String s = br.readLine();
                if (s == null || s.length() == 0) break;
                for (int j = 0; j < s.length(); j++) if (s.charAt(j) != '#') r++;
                a += s.length();
            }
            double rate = (double) r / a * 100;
            rate = Math.round(rate * 10) / 10.0;
            if (rate == (int) rate) System.out.printf("Efficiency ratio is %d%%.%n", (int) rate);
            else System.out.printf("Efficiency ratio is %.1f%%.%n", rate);
        }
    }
}