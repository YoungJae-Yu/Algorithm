import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        parent = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        
        bfs(1);  // 또는 dfs(1, -1); -> BFS/DFS 둘 다 사용 가능
        
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int child : tree.get(current)) {
                if (parent[child] == 0) {  // 아직 방문하지 않은 노드
                    parent[child] = current;
                    queue.add(child);
                }
            }
        }
    }

    static void dfs(int current, int par) {
        parent[current] = par;
        
        for (int child : tree.get(current)) {
            if (child != par) {
                dfs(child, current);
            }
        }
    }
}