import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] song = {
            "baby","sukhwan","tururu","turu",
            "very","cute","tururu","turu",
            "in","bed","tururu","turu",
            "baby","sukhwan"
        };
        int idx = (N - 1) % 14;
        int cycle = (N - 1) / 14;
        String cur = song[idx];
        if (cur.equals("tururu") || cur.equals("turu")) {
            String word = cur + "ru".repeat(cycle);
            int cnt = 0;
            for (int i = 0; i + 1 < word.length(); i++) {
                if (word.charAt(i) == 'r' && word.charAt(i + 1) == 'u') {
                    cnt++;
                }
            }
            if (cnt >= 5) {
                System.out.println("tu+ru*" + cnt);
            } else {
                System.out.println(word);
            }
        } else {
            System.out.println(cur);
        }
        sc.close();
    }
}