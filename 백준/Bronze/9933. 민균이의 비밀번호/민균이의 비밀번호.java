import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Set<String> set = new HashSet<>();
        String password = "";
        
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            set.add(word);
            String reversed = new StringBuilder(word).reverse().toString();
            if (set.contains(reversed)) {
                password = word;
                break;
            }
        }
        
        int length = password.length();
        char middle = password.charAt(length / 2);
        System.out.println(length + " " + middle);
        
        sc.close();
    }
}