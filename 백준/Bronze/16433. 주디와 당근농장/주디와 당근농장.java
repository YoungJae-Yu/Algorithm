import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int R = Integer.parseInt(in[1]);
        int C = Integer.parseInt(in[2]);
        int p = (R + C) % 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(((i + j) % 2 == p) ? 'v' : '.');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}