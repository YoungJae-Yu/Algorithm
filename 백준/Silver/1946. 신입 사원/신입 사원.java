import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int[][] arr = new int[N][2];
      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[i][0] = Integer.parseInt(st.nextToken());
        arr[i][1] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr, new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
          return a[0] - b[0];
        }
      });
      int cnt = 0;
      int best = Integer.MAX_VALUE;
      for (int i = 0; i < N; i++) {
        if (arr[i][1] < best) {
          cnt++;
          best = arr[i][1];
        }
      }
      sb.append(cnt).append('\n');
    }
    System.out.print(sb.toString());
  }
}