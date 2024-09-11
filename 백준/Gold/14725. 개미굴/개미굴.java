import java.util.*;

public class Main {
    static class TrieNode {
        Map<String, TrieNode> children = new TreeMap<>();
        
        void insert(String[] food, int index) {
            if (index == food.length) return;
            children.putIfAbsent(food[index], new TrieNode());
            children.get(food[index]).insert(food, index + 1);
        }
        
        void print(int depth) {
            for (String key : children.keySet()) {
                for (int i = 0; i < depth; i++) {
                    System.out.print("--");
                }
                System.out.println(key);
                children.get(key).print(depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        TrieNode root = new TrieNode();
        
        for (int i = 0; i < N; i++) {
            int K = sc.nextInt();
            String[] food = new String[K];
            for (int j = 0; j < K; j++) {
                food[j] = sc.next();
            }
            root.insert(food, 0);
        }
        
        root.print(0);
    }
}