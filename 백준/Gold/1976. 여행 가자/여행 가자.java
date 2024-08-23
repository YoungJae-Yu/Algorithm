import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int connected = sc.nextInt();
                if (connected == 1) {
                    union(i, j);
                }
            }
        }
        
        int[] plan = new int[m];
        for (int i = 0; i < m; i++) {
            plan[i] = sc.nextInt();
        }
        
        boolean possible = true;
        int root = find(plan[0]);
        for (int i = 1; i < m; i++) {
            if (find(plan[i]) != root) {
                possible = false;
                break;
            }
        }
        
        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
}