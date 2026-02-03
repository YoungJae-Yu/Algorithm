import java.io.*;
import java.util.*;

public class Main {
    static class Pair { int val, idx; Pair(int v,int i){val=v;idx=i;} }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Pair[] a = new Pair[N];
        for (int i = 0; i < N; i++) a[i] = new Pair(Integer.parseInt(st.nextToken()), i);
        Arrays.sort(a, Comparator.comparingInt(p -> p.val));
        int ans = 0;
        for (int i = 0; i < N; i++) ans = Math.max(ans, a[i].idx - i);
        System.out.println(ans);
    }
}