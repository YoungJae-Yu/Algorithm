import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] reachable = new boolean[26][26];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            st.nextToken(); // "is"
            int b = st.nextToken().charAt(0) - 'a';
            reachable[a][b] = true;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (!reachable[i][k]) continue;
                for (int j = 0; j < 26; j++) {
                    if (reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            st.nextToken(); // "is"
            int b = st.nextToken().charAt(0) - 'a';
            sb.append(reachable[a][b] ? "T" : "F").append('\n');
        }

        System.out.print(sb);
    }
}