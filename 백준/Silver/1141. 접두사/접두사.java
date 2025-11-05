import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = br.readLine().trim();
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1].startsWith(arr[i])) continue;
            ans++;
        }
        if (n > 0) ans++;
        System.out.println(ans);
    }
}