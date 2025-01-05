import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        
        int[] alphabetCount = new int[26];
        
        for (char c : input.toCharArray()) {
            alphabetCount[c - 'a']++;
        }
        
        for (int count : alphabetCount) {
            System.out.print(count + " ");
        }
    }
}