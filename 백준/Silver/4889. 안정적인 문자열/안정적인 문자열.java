import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int tc = 1;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.length() == 0) continue;
            if (line.charAt(0) == '-') break;
            int open = 0;
            int ans = 0;
            for (char c : line.toCharArray()) {
                if (c == '{') open++;
                else if (c == '}') {
                    if (open > 0) open--;
                    else {
                        ans++;
                        open = 1;
                    }
                }
            }
            ans += open / 2;
            sb.append(tc++).append(". ").append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}