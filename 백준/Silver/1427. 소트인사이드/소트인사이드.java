import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력받은 수를 문자열로 변환
        String input = br.readLine();
        
        // 문자열을 한 글자씩 나누어 배열에 저장
        Character[] numbers = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            numbers[i] = input.charAt(i);
        }
        
        // 배열을 내림차순으로 정렬
        Arrays.sort(numbers, Collections.reverseOrder());
        
        // 정렬된 배열을 다시 문자열로 결합하여 출력
        StringBuilder sb = new StringBuilder(numbers.length);
        for (Character num : numbers) {
            sb.append(num);
        }
        System.out.println(sb.toString());
    }
}
