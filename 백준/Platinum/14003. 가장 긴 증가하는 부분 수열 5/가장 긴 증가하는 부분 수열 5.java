import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int[] index = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        ArrayList<Integer> lis = new ArrayList<>();
        int length = 0;
        
        for (int i = 0; i < N; i++) {
            int pos = Collections.binarySearch(lis, arr[i]);
            if (pos < 0) pos = -(pos + 1);
            
            if (pos >= lis.size()) {
                lis.add(arr[i]);
                length++;
            } else {
                lis.set(pos, arr[i]);
            }
            
            dp[i] = pos + 1;
            index[pos] = i;
        }
        
        System.out.println(length);
        
        Stack<Integer> stack = new Stack<>();
        int current = length;
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == current) {
                stack.push(arr[i]);
                current--;
            }
        }
        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}