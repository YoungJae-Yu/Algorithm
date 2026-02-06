import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] phi = new long[N + 1];
        for (int i = 1; i <= N; i++) phi[i] = i;
        for (int i = 2; i <= N; i++) {
            if (phi[i] == i) {
                for (int j = i; j <= N; j += i) {
                    phi[j] -= phi[j] / i;
                }
            }
        }
        long sum = 0;
        for (int i = 2; i <= N; i++) sum += phi[i];
        System.out.println(sum);
    }
}