import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            sc.nextLine(); // 개행문자 처리
            
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = sc.nextLine();
            }

            Arrays.sort(words, Comparator.comparing(String::toLowerCase));
            System.out.println(words[0]);
        }
        sc.close();
    }
}