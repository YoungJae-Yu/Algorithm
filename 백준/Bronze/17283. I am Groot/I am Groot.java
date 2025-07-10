import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int R = Integer.parseInt(br.readLine());
        long sum = 0;
        long branches = 2;
        int length = L * R / 100;
        while (length > 5) {
            sum += length * branches;
            branches <<= 1;
            length = length * R / 100;
        }
        System.out.print(sum);
    }
}