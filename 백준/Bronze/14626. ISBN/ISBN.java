import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int idx = 0, sum = 0, weight;
        for (int i = 0; i < 12; i++) {
            if (s.charAt(i) == '*') {
                idx = i;
            } else {
                weight = (i % 2 == 0) ? 1 : 3;
                sum += (s.charAt(i) - '0') * weight;
            }
        }
        int check = s.charAt(12) - '0';
        weight = (idx % 2 == 0) ? 1 : 3;
        for (int d = 0; d < 10; d++) {
            if ((sum + d * weight + check) % 10 == 0) {
                System.out.println(d);
                break;
            }
        }
    }
}