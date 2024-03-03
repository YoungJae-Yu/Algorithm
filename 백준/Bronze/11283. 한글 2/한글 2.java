import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int unicode = word.charAt(0);

        int cho = (unicode - 44032) / (21 * 28);
        int jung = (unicode - 44032 - (cho * 21 * 28)) / 28;
        int jong = unicode - 44032 - (cho * 21 * 28) - (jung * 28);

        System.out.println(cho * 21 * 28 + jung * 28 + jong + 1);
    }
}
