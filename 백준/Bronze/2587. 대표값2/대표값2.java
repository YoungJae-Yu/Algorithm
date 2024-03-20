import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] numbers = new int[5]; // 다섯 개의 수를 저장할 배열
        int sum = 0; // 수들의 합을 저장할 변수
        
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt(); // 수 입력
            sum += numbers[i]; // 입력받은 수를 합에 더함
        }
        
        Arrays.sort(numbers); // 배열을 오름차순으로 정렬
        
        int average = sum / 5; // 평균 계산
        int median = numbers[2]; // 중앙값 계산
        
        System.out.println(average); // 평균 출력
        System.out.println(median); // 중앙값 출력
        
        scanner.close();
    }
}
