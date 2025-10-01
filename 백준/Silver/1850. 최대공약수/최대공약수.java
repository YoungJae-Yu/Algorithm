import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long g = gcd(a, b);
        int len = (int) g;
        char[] arr = new char[len];
        Arrays.fill(arr, '1');
        System.out.println(new String(arr));
    }

    static long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}