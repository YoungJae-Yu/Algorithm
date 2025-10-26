import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(Integer.parseInt(st.nextToken()));
        dfs(arr, 0);
        System.out.println(ans);
    }
    static void dfs(ArrayList<Integer> arr, int sum) {
        if (arr.size() == 2) {
            if (sum > ans) ans = sum;
            return;
        }
        for (int i = 1; i <= arr.size() - 2; i++) {
            int gain = arr.get(i - 1) * arr.get(i + 1);
            int removed = arr.remove(i);
            dfs(arr, sum + gain);
            arr.add(i, removed);
        }
    }
}