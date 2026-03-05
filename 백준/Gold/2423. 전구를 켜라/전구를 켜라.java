import java.io.*;
import java.util.*;

public class Main {
    static int id(int i, int j, int mPlus1){ return i*(mPlus1) + j; }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] a = new char[n+1][m+1];
        for(int i=1;i<=n;i++){
            String line = br.readLine();
            for(int j=1;j<=m;j++) a[i][j] = line.charAt(j-1);
        }
        int rows = n+1, cols = m+1;
        int V = rows * cols;
        ArrayList<int[]>[] g = new ArrayList[V];
        for(int i=0;i<V;i++) g[i] = new ArrayList<>();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i][j] == '/'){
                    int u1 = id(i-1, j-1, cols), v1 = id(i, j, cols);
                    g[u1].add(new int[]{v1,1}); g[v1].add(new int[]{u1,1});
                    int u2 = id(i-1, j, cols), v2 = id(i, j-1, cols);
                    g[u2].add(new int[]{v2,0}); g[v2].add(new int[]{u2,0});
                } else {
                    int u1 = id(i-1, j-1, cols), v1 = id(i, j, cols);
                    g[u1].add(new int[]{v1,0}); g[v1].add(new int[]{u1,0});
                    int u2 = id(i-1, j, cols), v2 = id(i, j-1, cols);
                    g[u2].add(new int[]{v2,1}); g[v2].add(new int[]{u2,1});
                }
            }
        }
        final int INF = Integer.MAX_VALUE/4;
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        int src = id(0,0,cols), trg = id(n,m,cols);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x->x[0]));
        dist[src] = 0;
        pq.add(new int[]{0, src});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if(d != dist[u]) continue;
            if(u == trg) break;
            for(int[] e : g[u]){
                int v = e[0], w = e[1];
                if(dist[v] > d + w){
                    dist[v] = d + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }
        if(dist[trg] < INF) System.out.println(dist[trg]);
        else System.out.println("NO SOLUTION");
    }
}