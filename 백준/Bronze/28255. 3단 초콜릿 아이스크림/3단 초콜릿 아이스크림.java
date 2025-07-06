import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String S = br.readLine();
            int n = S.length();
            int k = (n + 2) / 3;

            String p = S.substring(0, k);
            String revp = new StringBuilder(p).reverse().toString();
            String tailp = p.substring(1);
            String tailrev = revp.substring(1);

            boolean ok = S.equals(p + revp + p)
                      || S.equals(p + revp + tailp)
                      || S.equals(p + tailrev + p)
                      || S.equals(p + tailrev + tailp);

            sb.append(ok ? '1' : '0').append('\n');
        }

        System.out.print(sb);
    }
}