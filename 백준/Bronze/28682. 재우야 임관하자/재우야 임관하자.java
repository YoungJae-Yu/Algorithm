import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if (i > 0) bw.write(' ');
            bw.write("swimming");
        }
        bw.write('\n');
        bw.flush();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String fail = st.nextToken();
            if (i > 0) sb.append(' ');
            if (fail.equals("bowling")) sb.append("soccer");
            else sb.append("bowling");
        }
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
    }
}