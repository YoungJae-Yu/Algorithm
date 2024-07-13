import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n + 1];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        heights[n] = 0;

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }

        System.out.println(maxArea);
    }
}