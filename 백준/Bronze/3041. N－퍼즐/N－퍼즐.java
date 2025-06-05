import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalDistance = 0;
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 4; j++) {
                char c = line.charAt(j);
                if (c == '.') continue;
                int idx = c - 'A';
                int goalRow = idx / 4;
                int goalCol = idx % 4;
                totalDistance += Math.abs(i - goalRow) + Math.abs(j - goalCol);
            }
        }
        System.out.println(totalDistance);
    }
}