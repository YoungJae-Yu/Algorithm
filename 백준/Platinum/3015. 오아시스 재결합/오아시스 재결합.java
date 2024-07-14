import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        Stack<int[]> stack = new Stack<>();
        long count = 0;

        for (int i = 0; i < n; i++) {
            int[] current = {heights[i], 1};

            while (!stack.isEmpty() && stack.peek()[0] <= heights[i]) {
                int[] top = stack.pop();
                count += top[1];
                if (top[0] == heights[i]) {
                    current[1] += top[1];
                }
            }

            if (!stack.isEmpty()) {
                count++;
            }

            stack.push(current);
        }

        System.out.println(count);
    }
}