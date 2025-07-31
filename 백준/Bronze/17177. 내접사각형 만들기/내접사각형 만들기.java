import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double p = a;
        double q = 2 * b * c;
        double r = a * (c * c - a * a + b * b);
        double D = q * q - 4 * p * r;

        if (D < 0) {
            System.out.print(-1);
            return;
        }

        double x = (-q + Math.sqrt(D)) / (2 * p);
        if (x < 0) {
            System.out.print(-1);
            return;
        }

        double EPS = 1e-5;
        System.out.print((int)(x + EPS));
    }
}