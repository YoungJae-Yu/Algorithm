import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = num;

        for(int i = 0; i < num; i++) {
            String word = scanner.next();
            boolean[] check = new boolean[26];

            for(int j = 1; j < word.length(); j++) {
                if(word.charAt(j-1) != word.charAt(j)) {
                    if(check[word.charAt(j) - 97] == true) {
                        count--;
                        break;
                    }
                    check[word.charAt(j-1) - 97] = true;
                }
            }
        }
        System.out.println(count);
    }
}
