import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (isHanNumber(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    // 등차수열인지 확인하는 함수
    public static boolean isHanNumber(int num) {
        if (num < 100) {
            return true; // 두 자리 수까지는 모두 등차수열
        } else {
            String strNum = String.valueOf(num);
            int[] digits = new int[strNum.length()];

            // 각 자릿수를 배열에 저장
            for (int i = 0; i < strNum.length(); i++) {
                digits[i] = strNum.charAt(i) - '0';
            }

            // 등차수열 확인
            int diff = digits[1] - digits[0];
            for (int i = 2; i < digits.length; i++) {
                if (digits[i] - digits[i - 1] != diff) {
                    return false;
                }
            }
            return true;
        }
    }
}
