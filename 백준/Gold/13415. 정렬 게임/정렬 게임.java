import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine().trim());
        ArrayList<int[]> stack = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            for (int[] op : new int[][]{{a,1},{b,0}}) {
                int idx = op[0], type = op[1];
                while (!stack.isEmpty() && stack.get(stack.size()-1)[0] <= idx) stack.remove(stack.size()-1);
                stack.add(new int[]{idx,type});
            }
        }
        stack.add(new int[]{-1,0});
        if (stack.get(0)[0] < 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (i>0) sb.append(' ');
                sb.append(arr[i]);
            }
            System.out.println(sb.toString());
            return;
        }
        int maxIdx = stack.get(0)[0];
        int len = maxIdx + 1;
        int[] temp = Arrays.copyOfRange(arr, 0, len);
        Arrays.sort(temp);
        Deque<Integer> dq = new ArrayDeque<>();
        for (int v : temp) dq.add(v);
        for (int i = 0; i < stack.size() - 1; i++) {
            int cur = stack.get(i)[0];
            int type = stack.get(i)[1];
            int next = stack.get(i+1)[0];
            for (int j = cur; j > next; j--) {
                int val = (type == 1) ? dq.removeLast() : dq.removeFirst();
                arr[j] = val;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i>0) sb.append(' ');
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }
}