import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for (int i = N; i >= 4; i--) {
            if (isGoldMinNumber(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    private static boolean isGoldMinNumber(int num) {
        String str = String.valueOf(num);
        for (char c : str.toCharArray()) {
            if (c != '4' && c != '7') {
                return false;
            }
        }
        return true;
    }
}