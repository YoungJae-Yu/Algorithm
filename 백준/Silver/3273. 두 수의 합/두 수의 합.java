import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] numbers = new int[n];
        
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        
        int x = sc.nextInt();
        
        Arrays.sort(numbers);
        
        int left = 0;
        int right = n - 1;
        int count = 0;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == x) {
                count++;
                left++;
                right--;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }
        
        System.out.println(count);
        sc.close();
    }
}