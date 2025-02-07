import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dwarfs = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = sc.nextInt();
            total += dwarfs[i];
        }
        boolean found = false;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - (dwarfs[i] + dwarfs[j]) == 100) {
                    int[] result = new int[7];
                    int idx = 0;
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j) continue;
                        result[idx++] = dwarfs[k];
                    }
                    Arrays.sort(result);
                    for (int num : result) {
                        System.out.println(num);
                    }
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
    }
}