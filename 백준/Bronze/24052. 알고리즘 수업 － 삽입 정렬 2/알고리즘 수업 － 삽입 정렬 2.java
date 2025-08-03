import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 배열의 크기
        int k = Integer.parseInt(st.nextToken()); // 목표 교환 횟수

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int swapCount = 0; // 교환 횟수 카운트

        for (int i = 1; i < n; i++) {
            int loc = i - 1;
            int newItem = arr[i];

            // newItem이 들어갈 위치를 찾습니다.
            while (loc >= 0 && newItem < arr[loc]) {
                arr[loc + 1] = arr[loc];
                loc--;
                swapCount++; // 위치 변경이 일어날 때마다 카운트
                if (swapCount == k) {
                    printArray(arr);
                    return;
                }
            }

            if (loc + 1 != i) {
                arr[loc + 1] = newItem;
                swapCount++; // 최종 위치에 삽입될 때 카운트
                 if (swapCount == k) {
                    printArray(arr);
                    return;
                }
            }
        }

        System.out.println(-1); // K번의 교환이 일어나지 않은 경우
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
