import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        Node[] children = new Node[26];
        int childCount = 0;
        boolean isEnd = false;
    }

    static void insert(Node root, String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Node();
                node.childCount++;
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    static int countKeyPresses(Node root, String word) {
        Node node = root;
        int presses = 0;
        for (int i = 0; i < word.length(); i++) {
            if (node == root || node.childCount > 1 || node.isEnd) {
                presses++;
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        return presses;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.trim());
            String[] words = new String[n];
            Node root = new Node();
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine().trim();
                insert(root, words[i]);
            }
            int totalPresses = 0;
            for (String word : words) {
                totalPresses += countKeyPresses(root, word);
            }
            double average = (double) totalPresses / n;
            System.out.printf("%.2f\n", average);
        }
    }
}