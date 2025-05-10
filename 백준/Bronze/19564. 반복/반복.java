import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 1;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr <= prev) {
                count++;
            }
            prev = curr;
        }
        System.out.print(count);
    }
}