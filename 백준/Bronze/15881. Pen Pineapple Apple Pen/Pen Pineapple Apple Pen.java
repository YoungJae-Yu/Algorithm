import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;
        for (int i = 0; i <= N - 4; i++) {
            if (S.charAt(i) == 'p' &&
                S.charAt(i + 1) == 'P' &&
                S.charAt(i + 2) == 'A' &&
                S.charAt(i + 3) == 'p') {
                count++;
                i += 3; // 중복 방지를 위해 패턴 길이만큼 건너뜀
            }
        }

        System.out.println(count);
    }
}