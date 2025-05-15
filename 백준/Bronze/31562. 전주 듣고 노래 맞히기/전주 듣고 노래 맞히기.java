import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String title = st.nextToken();
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                key.append(st.nextToken());
            }
            String k = key.toString();
            if (map.containsKey(k)) {
                map.put(k, "?");
            } else {
                map.put(k, title);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            StringBuilder key = new StringBuilder();
            key.append(st.nextToken()).append(st.nextToken()).append(st.nextToken());
            String result = map.getOrDefault(key.toString(), "!");
            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}