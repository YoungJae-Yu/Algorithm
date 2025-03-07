import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String a = sc.next();
            String b = sc.next();
            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();
            Arrays.sort(aChars);
            Arrays.sort(bChars);
            if (Arrays.equals(aChars, bChars)) {
                System.out.println(a + " & " + b + " are anagrams.");
            } else {
                System.out.println(a + " & " + b + " are NOT anagrams.");
            }
        }
    }
}