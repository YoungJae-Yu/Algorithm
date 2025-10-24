import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        String L = parts[0];
        String R = parts[1];

        if (L.length() != R.length()) {
            System.out.println(0);
            return;
        }

        int count = 0;
        for (int i = 0; i < L.length(); i++) {
            char a = L.charAt(i);
            char b = R.charAt(i);
            if (a != b) break;
            if (a == '8') count++;
        }
        System.out.println(count);
    }
}