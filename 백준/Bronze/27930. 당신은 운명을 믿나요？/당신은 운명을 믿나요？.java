import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String kor = "KOREA", yon = "YONSEI";
        int k = 0, y = 0;
        for (char c : s.toCharArray()) {
            if (k < kor.length() && c == kor.charAt(k)) {
                k++;
                if (k == kor.length()) {
                    System.out.println("KOREA");
                    return;
                }
            }
            if (y < yon.length() && c == yon.charAt(y)) {
                y++;
                if (y == yon.length()) {
                    System.out.println("YONSEI");
                    return;
                }
            }
        }
    }
}