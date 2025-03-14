import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        sc.close();

        int happyCount = countOccurrences(text, ":-)");
        int sadCount = countOccurrences(text, ":-(");

        if (happyCount == 0 && sadCount == 0) {
            System.out.println("none");
        } else if (happyCount > sadCount) {
            System.out.println("happy");
        } else if (happyCount < sadCount) {
            System.out.println("sad");
        } else {
            System.out.println("unsure");
        }
    }

    private static int countOccurrences(String text, String target) {
        int count = 0, index = 0;
        while ((index = text.indexOf(target, index)) != -1) {
            count++;
            index += target.length();
        }
        return count;
    }
}