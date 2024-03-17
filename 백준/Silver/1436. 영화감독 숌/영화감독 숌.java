import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사용자로부터 N을 입력받음
        int number = 666; // 종말의 숫자 시작
        int count = 1; // 현재까지 찾은 종말의 숫자의 갯수

        while(count < N) {
            number++; // 다음 숫자로 이동
            if(String.valueOf(number).contains("666")) { // 현재 숫자에 666이 포함되어 있다면
                count++; // 찾은 종말의 숫자의 갯수를 증가
            }
        }

        System.out.println(number); // N번째 종말의 숫자 출력
    }
}
