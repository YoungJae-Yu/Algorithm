import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        boolean cute = true;
        if (n >= 3) {
            int diff = (s.charAt(1) - '0') - (s.charAt(0) - '0');
            for (int i = 2; i < n; i++) {
                if ((s.charAt(i) - '0') - (s.charAt(i - 1) - '0') != diff) {
                    cute = false;
                    break;
                }
            }
        }
        if (cute) {
            System.out.print("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
        } else {
            System.out.print("흥칫뿡!! <(￣ ﹌ ￣)>");
        }
    }
}