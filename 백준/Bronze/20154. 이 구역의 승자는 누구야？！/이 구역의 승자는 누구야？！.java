import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] alpha = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        int n = s.length;
        int[] curr = new int[n];
        for (int i = 0; i < n; i++) curr[i] = alpha[s[i] - 'A'];
        while (n > 1) {
            int m = (n + 1) / 2;
            int[] next = new int[m];
            for (int i = 0; i < n / 2; i++)
                next[i] = (curr[2*i] + curr[2*i+1]) % 10;
            if ((n & 1) == 1) next[m-1] = curr[n-1];
            curr = next;
            n = m;
        }
        System.out.println((curr[0] % 2 == 1) ? "I'm a winner!" : "You're the winner?");
    }
}