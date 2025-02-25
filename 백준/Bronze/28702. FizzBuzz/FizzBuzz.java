import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 세 줄 입력 받기
        String[] inputs = new String[3];
        for (int i = 0; i < 3; i++) {
            inputs[i] = br.readLine();
        }
        
        // 숫자가 있는 위치 찾기와 그 수의 값 구하기
        int lastNum = 0;
        int lastNumIndex = 0;
        
        for (int i = 0; i < 3; i++) {
            if (isNumeric(inputs[i])) {
                lastNum = Integer.parseInt(inputs[i]);
                lastNumIndex = i;
                break;
            }
        }
        
        // 목표 숫자 계산 (입력에서 주어진 숫자에서 목표까지의 거리)
        int targetNum = lastNum + (3 - lastNumIndex);
        
        // 규칙에 따라 출력
        if (targetNum % 3 == 0 && targetNum % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (targetNum % 3 == 0) {
            System.out.println("Fizz");
        } else if (targetNum % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(targetNum);
        }
    }
    
    // 문자열이 숫자인지 확인하는 메서드
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}