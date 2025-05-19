import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n != 3) {
            System.out.println("Woof-meow-tweet-squeek");
            return;
        }
        Set<String> s = new HashSet<>(Arrays.asList("1 3", "1 4", "3 4"));
        for (int i = 0; i < 3; i++) {
            String[] t = br.readLine().split(" ");
            int a = Integer.parseInt(t[0]), b = Integer.parseInt(t[1]);
            String key = a < b ? a + " " + b : b + " " + a;
            s.remove(key);
        }
        System.out.println(s.isEmpty() ? "Wa-pa-pa-pa-pa-pa-pow!" : "Woof-meow-tweet-squeek");
    }
}