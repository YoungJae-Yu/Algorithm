import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  
        int[] heights = new int[N];
        
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        
        int maxRise = 0;
        int start = heights[0];

        for (int i = 1; i < N; i++) {
            if (heights[i] > heights[i - 1]) { 
                continue;
            } else {
                maxRise = Math.max(maxRise, heights[i - 1] - start);
                start = heights[i]; 
            }
        }

        maxRise = Math.max(maxRise, heights[N - 1] - start);

        System.out.println(maxRise);
    }
}