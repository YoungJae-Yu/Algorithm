import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] line = new int[N];
        for (int i = 0; i < N; i++) {
            line[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                num++;
            }
            if (line[i] == num) {
                num++;
            } else {
                stack.push(line[i]);
            }
        }
        
        while (!stack.isEmpty() && stack.peek() == num) {
            stack.pop();
            num++;
        }

        if (num - 1 == N) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
