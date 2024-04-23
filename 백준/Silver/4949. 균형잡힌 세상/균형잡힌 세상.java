import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break; // 입력의 종료 조건
            
            System.out.println(isBalanced(line) ? "yes" : "no");
        }
    }

    private static boolean isBalanced(String line) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            
            // 여는 괄호일 경우 스택에 추가
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    // 짝이 맞지 않는 경우
                    return false;
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    // 짝이 맞지 않는 경우
                    return false;
                }
            }
        }
        
        return stack.isEmpty(); // 스택이 비어있으면 균형잡힌 것
    }
}
