import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] codeCount = new int[53];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            codeCount[Integer.parseInt(st.nextToken())]++;
        }
        String text = br.readLine();
        int[] textCount = new int[53];
        for (char c : text.toCharArray()) {
            if (c == ' ') textCount[0]++;
            else if (c >= 'A' && c <= 'Z') textCount[c - 'A' + 1]++;
            else if (c >= 'a' && c <= 'z') textCount[c - 'a' + 27]++;
        }
        boolean ok = true;
        for (int i = 0; i < 53; i++) {
            if (codeCount[i] != textCount[i]) {
                ok = false;
                break;
            }
        }
        System.out.println(ok ? "y" : "n");
    }
}
