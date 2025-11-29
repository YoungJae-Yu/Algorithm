import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[] a = br.readLine().toCharArray();
            int n = a.length;
            int i = n - 2;
            while (i >= 0 && a[i] >= a[i + 1]) i--;
            if (i < 0) {
                sb.append(new String(a)).append('\n');
                continue;
            }
            int j = n - 1;
            while (a[j] <= a[i]) j--;
            char tmp = a[i]; a[i] = a[j]; a[j] = tmp;
            int l = i + 1, r = n - 1;
            while (l < r) {
                char t = a[l]; a[l] = a[r]; a[r] = t;
                l++; r--;
            }
            sb.append(new String(a)).append('\n');
        }
        System.out.print(sb.toString());
    }
}