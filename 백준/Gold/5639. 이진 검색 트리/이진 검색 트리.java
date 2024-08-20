import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }

    void insert(int value) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = new Node(value);
            } else {
                this.left.insert(value);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(value);
            } else {
                this.right.insert(value);
            }
        }
    }

    void postOrder(StringBuilder sb) {
        if (this.left != null) this.left.postOrder(sb);
        if (this.right != null) this.right.postOrder(sb);
        sb.append(this.value).append('\n');
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            list.add(Integer.parseInt(input));
        }

        Node root = new Node(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            root.insert(list.get(i));
        }

        StringBuilder sb = new StringBuilder();
        root.postOrder(sb);
        System.out.print(sb);
    }
}