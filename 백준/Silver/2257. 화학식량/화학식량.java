import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();

        Stack<Integer> stack = new Stack<>();
        Map<Character, Integer> mass = Map.of(
            'H', 1,
            'C', 12,
            'O', 16
        );

        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);

            if (mass.containsKey(c)) {
                stack.push(mass.get(c));
            } else if (c == '(') {
                stack.push(-1); 
            } else if (c == ')') {
                int sum = 0;
                while (!stack.isEmpty() && stack.peek() != -1) {
                    sum += stack.pop();
                }
                stack.pop(); 
                stack.push(sum);
            } else { // 숫자 2~9
                int prev = stack.pop();
                stack.push(prev * (c - '0'));
            }
        }

        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        System.out.println(total);
    }
}