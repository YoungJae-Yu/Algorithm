import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        long min = Long.parseLong(parts[0]);
        long max = Long.parseLong(parts[1]);
        int size = (int)(max - min + 1);

        boolean[] isNotSquareFree = new boolean[size];
        long cnt = size;

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start = (min + square - 1) / square;  // ceil(min / square)
            for (long j = start; j * square <= max; j++) {
                int idx = (int)(j * square - min);
                if (!isNotSquareFree[idx]) {
                    isNotSquareFree[idx] = true;
                    cnt--;
                }
            }
        }

        System.out.println(cnt);
    }
}