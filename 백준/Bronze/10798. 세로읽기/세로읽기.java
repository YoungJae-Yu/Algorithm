import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[5];
        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.next();
            maxLen = Math.max(maxLen, arr[i].length());
        }

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < arr[j].length())
                    System.out.print(arr[j].charAt(i));
            }
        }
    }
}
