import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        boolean isYujin = false;
        
        for (int i = 1; i < n.length(); i++) {
            String left = n.substring(0, i);
            String right = n.substring(i);
            
            long leftProd = 1;
            long rightProd = 1;
            
            for (char c : left.toCharArray()) {
                leftProd *= (c - '0');
            }
            for (char c : right.toCharArray()) {
                rightProd *= (c - '0');
            }
            
            if (leftProd == rightProd) {
                isYujin = true;
                break;
            }
        }
        
        System.out.println(isYujin ? "YES" : "NO");
    }
}