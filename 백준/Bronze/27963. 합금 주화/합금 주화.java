import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int chi = Integer.parseInt(st.nextToken());
        
        if (d1 < d2) {
            int tmp = d1; d1 = d2; d2 = tmp;
        }

        double volume = (double) chi / d1 + (double) (100 - chi) / d2;
        double result = 100.0 / volume;
        System.out.printf("%.6f", result);
    }
}