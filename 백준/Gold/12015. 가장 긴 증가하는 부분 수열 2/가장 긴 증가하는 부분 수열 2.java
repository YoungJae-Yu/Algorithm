import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        System.out.println(lengthOfLIS(A));
        scanner.close();
    }
    
    private static int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        
        for (int num : nums) {
            if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
                lis.add(num);
            } else {
                int pos = Collections.binarySearch(lis, num);
                if (pos < 0) {
                    pos = -(pos + 1);
                }
                lis.set(pos, num);
            }
        }
        
        return lis.size();
    }
}