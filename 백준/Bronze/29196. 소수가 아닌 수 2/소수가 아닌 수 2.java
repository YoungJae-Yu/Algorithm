import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String k = br.readLine().trim();
        int dot = k.indexOf('.');
        if (dot == -1) {
            // 정수만 주어진 경우
            System.out.println("YES");
            System.out.println(k + " 1");
        } else {
            String intPart = k.substring(0, dot);
            String fracPart = k.substring(dot + 1);
            long q = 1;
            for (int i = 0; i < fracPart.length(); i++) {
                q *= 10;
            }
            long p = Long.parseLong(intPart) * q + Long.parseLong(fracPart);
            System.out.println("YES");
            System.out.println(p + " " + q);
        }
    }
}