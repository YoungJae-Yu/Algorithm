import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine().trim(); // 입력 문자열
        sc.close();

        int mod = 20000303;
        long result = 0;

        for (int i = 0; i < number.length(); i++) {
            result = (result * 10 + (number.charAt(i) - '0')) % mod;
        }

        System.out.println(result);
    }
}