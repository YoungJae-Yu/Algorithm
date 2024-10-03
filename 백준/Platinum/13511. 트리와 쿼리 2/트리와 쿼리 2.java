import java.io.*;
import java.util.*;

public class Main {
    static int N, LOG;
    static List<Edge>[] tree;
    static int[][] parent;
    static int[] depth;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        LOG = (int) (Math.log(N) / Math.log(2)) + 1;
        
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[u].add(new Edge(v, w));
            tree[v].add(new Edge(u, w));
        }
        
        parent = new int[N + 1][LOG];
        depth = new int[N + 1];
        dist = new long[N + 1];
        
        dfs(1, 0, 0);
        setParent();
        
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            if (t == 1) {
                bw.write(distance(u, v) + "\n");
            } else {
                int k = Integer.parseInt(st.nextToken());
                bw.write(findKthNode(u, v, k) + "\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    static void dfs(int node, int par, int d) {
        depth[node] = d;
        parent[node][0] = par;
        
        for (Edge edge : tree[node]) {
            if (edge.to != par) {
                dist[edge.to] = dist[node] + edge.weight;
                dfs(edge.to, node, d + 1);
            }
        }
    }
    
    static void setParent() {
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= N; i++) {
                parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }
    }
    
    static int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[u] - depth[v] >= (1 << i)) {
                u = parent[u][i];
            }
        }
        
        if (u == v) return u;
        
        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }
        
        return parent[u][0];
    }
    
    static long distance(int u, int v) {
        int lcaNode = lca(u, v);
        return dist[u] + dist[v] - 2 * dist[lcaNode];
    }
    
    static int findKthNode(int u, int v, int k) {
        int lcaNode = lca(u, v);
        int uLen = depth[u] - depth[lcaNode];
        int vLen = depth[v] - depth[lcaNode];
        
        if (k <= uLen + 1) {
            return findKthAncestor(u, k - 1);
        } else {
            return findKthAncestor(v, uLen + vLen - (k - 1));
        }
    }
    
    static int findKthAncestor(int node, int k) {
        for (int i = LOG - 1; i >= 0; i--) {
            if ((1 << i) <= k) {
                node = parent[node][i];
                k -= (1 << i);
            }
        }
        return node;
    }
    
    static class Edge {
        int to, weight;
        
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}