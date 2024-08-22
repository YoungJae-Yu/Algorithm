import java.util.Scanner;

public class Main {
    static int[] parent;

    // 특정 원소가 속한 집합을 찾는 함수 (경로 압축 적용)
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    // 두 원소가 속한 집합을 합치는 함수 (유니온 바이 랭크)
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rootX < rootY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int operation = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (operation == 0) {
                union(a, b);
            } else if (operation == 1) {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}