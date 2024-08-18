import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Character, Node> tree = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거
        
        for (int i = 0; i < n; i++) {
            char root = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);
            tree.put(root, new Node(left, right));
        }
        
        preorder('A');
        System.out.println();
        inorder('A');
        System.out.println();
        postorder('A');
        System.out.println();
    }

    public static void preorder(char root) {
        if (root == '.') return;
        System.out.print(root);
        preorder(tree.get(root).left);
        preorder(tree.get(root).right);
    }

    public static void inorder(char root) {
        if (root == '.') return;
        inorder(tree.get(root).left);
        System.out.print(root);
        inorder(tree.get(root).right);
    }

    public static void postorder(char root) {
        if (root == '.') return;
        postorder(tree.get(root).left);
        postorder(tree.get(root).right);
        System.out.print(root);
    }
}

class Node {
    char left, right;
    
    Node(char left, char right) {
        this.left = left;
        this.right = right;
    }
}