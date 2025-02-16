import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        
        while (T-- > 0) {
            Integer[] arr = new Integer[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }
            
            Arrays.sort(arr, Collections.reverseOrder());
            System.out.println(arr[2]);
        }
        
        sc.close();
    }
}