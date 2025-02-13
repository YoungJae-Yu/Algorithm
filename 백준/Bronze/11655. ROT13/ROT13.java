import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char)('a' + (c - 'a' + 13) % 26);
            } else if (c >= 'A' && c <= 'Z') {
                c = (char)('A' + (c - 'A' + 13) % 26);
            }
            sb.append(c);
        }
        System.out.println(sb);
    }
}