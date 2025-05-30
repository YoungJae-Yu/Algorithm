import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();                        // N 읽고 버리기
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 2) == 'P' && sb.charAt(n - 1) == 'S'
                    && (c == '4' || c == '5')) continue;
            sb.append(c);
        }
        System.out.print(sb);
    }
}