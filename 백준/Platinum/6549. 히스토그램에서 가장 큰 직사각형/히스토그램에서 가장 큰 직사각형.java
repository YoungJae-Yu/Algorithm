import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) break;

            long[] heights = new long[n];
            for (int i = 0; i < n; i++) {
                heights[i] = scanner.nextLong();
            }

            System.out.println(getMaxRectangleArea(heights));
        }
        scanner.close();
    }

    private static long getMaxRectangleArea(long[] heights) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int i = 0;

        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                long height = heights[top];
                long width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            long height = heights[top];
            long width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}