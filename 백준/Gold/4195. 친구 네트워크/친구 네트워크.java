import java.io.*;
import java.util.*;

public class Main {
    static Map<String, String> parent;
    static Map<String, Integer> size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());
            parent = new HashMap<>();
            size = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < F; i++) {
                String[] friends = br.readLine().split(" ");
                String person1 = friends[0];
                String person2 = friends[1];

                union(person1, person2);
                sb.append(size.get(find(person1))).append("\n");
            }

            System.out.print(sb.toString());
        }
    }

    static String find(String person) {
        if (parent.get(person).equals(person)) {
            return person;
        } else {
            String root = find(parent.get(person));
            parent.put(person, root);
            return root;
        }
    }

    static void union(String person1, String person2) {
        if (!parent.containsKey(person1)) {
            parent.put(person1, person1);
            size.put(person1, 1);
        }
        if (!parent.containsKey(person2)) {
            parent.put(person2, person2);
            size.put(person2, 1);
        }

        String root1 = find(person1);
        String root2 = find(person2);

        if (!root1.equals(root2)) {
            if (size.get(root1) < size.get(root2)) {
                parent.put(root1, root2);
                size.put(root2, size.get(root1) + size.get(root2));
            } else {
                parent.put(root2, root1);
                size.put(root1, size.get(root1) + size.get(root2));
            }
        }
    }
}