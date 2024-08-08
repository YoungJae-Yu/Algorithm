import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int finalLeft = 0;
        int finalRight = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                finalLeft = left;
                finalRight = right;
            }
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(arr[finalLeft] + " " + arr[finalRight]);
    }
}