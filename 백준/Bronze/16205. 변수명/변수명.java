import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int type = Integer.parseInt(parts[0]);
        String name = parts[1];
        ArrayList<String> words = new ArrayList<>();

        if (type == 2) {
            for (String w : name.split("_")) {
                words.add(w);
            }
        } else {
            StringBuilder curr = new StringBuilder();
            for (char c : name.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    if (curr.length() > 0) {
                        words.add(curr.toString());
                    }
                    curr = new StringBuilder();
                    curr.append(Character.toLowerCase(c));
                } else {
                    curr.append(c);
                }
            }
            if (curr.length() > 0) {
                words.add(curr.toString());
            }
        }

        // camelCase
        StringBuilder camel = new StringBuilder(words.get(0));
        for (int i = 1; i < words.size(); i++) {
            String w = words.get(i);
            camel.append(Character.toUpperCase(w.charAt(0)))
                 .append(w.substring(1));
        }

        // snake_case
        StringBuilder snake = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            if (i > 0) snake.append('_');
            snake.append(words.get(i));
        }

        // PascalCase
        StringBuilder pascal = new StringBuilder();
        for (String w : words) {
            pascal.append(Character.toUpperCase(w.charAt(0)))
                  .append(w.substring(1));
        }

        System.out.println(camel);
        System.out.println(snake);
        System.out.println(pascal);
    }
}