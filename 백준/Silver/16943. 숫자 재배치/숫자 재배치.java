import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] a = st.nextToken().toCharArray();
        int B = Integer.parseInt(st.nextToken());
        Arrays.sort(a);
        long ans = -1;
        do {
            if (a[0] == '0') continue;
            long val = 0;
            for (char c : a) val = val * 10 + (c - '0');
            if (val <= B && val > ans) ans = val;
        } while (nextPermutation(a));
        System.out.println(ans);
    }

    static boolean nextPermutation(char[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false;
        int j = a.length - 1;
        while (a[j] <= a[i]) j--;
        char t = a[i]; a[i] = a[j]; a[j] = t;
        int l = i + 1, r = a.length - 1;
        while (l < r) {
            char tmp = a[l]; a[l] = a[r]; a[r] = tmp;
            l++; r--;
        }
        return true;
    }
}