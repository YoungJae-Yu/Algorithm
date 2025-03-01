import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 5개 숫자 배열 생성
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 버블 정렬 구현
        boolean sorted = false;
        while (!sorted) {
            sorted = true; // 정렬 완료 체크 플래그
            
            for (int i = 0; i < 4; i++) {
                // 인접한 두 수 비교
                if (arr[i] > arr[i + 1]) {
                    // 스왑
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    
                    // 스왑 후 배열 출력
                    printArray(arr);
                    sorted = false; // 아직 정렬이 완료되지 않음
                }
            }
            
            // 배열이 1 2 3 4 5인지 체크
            if (arr[0] == 1 && arr[1] == 2 && arr[2] == 3 && 
                arr[3] == 4 && arr[4] == 5) {
                break;
            }
        }
    }
    
    // 배열 출력 메서드
    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(arr[i]);
            if (i < 4) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}