import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
        public int compareTo(Edge o) { return Integer.compare(this.w, o.w); }
    }

    static class UnionFind {
        int[] p;
        UnionFind(int n) { p = new int[n]; for (int i=0;i<n;i++) p[i]=i; }
        int find(int x) { return p[x]==x?x:(p[x]=find(p[x])); }
        boolean union(int a,int b) {
            a=find(a); b=find(b);
            if (a==b) return false;
            p[b]=a;
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        ArrayList<int[]> nodes = new ArrayList<>();
        for (int i=0;i<N;i++) {
            String s = br.readLine();
            for (int j=0;j<N;j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j]=='S') nodes.add(new int[]{i,j});
            }
        }
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (map[i][j]=='K') nodes.add(new int[]{i,j});
            }
        }
        int V = nodes.size();
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i=0;i<V;i++) {
            int[][] dist = bfs(nodes.get(i)[0], nodes.get(i)[1]);
            for (int j=i+1;j<V;j++) {
                int tr = nodes.get(j)[0], tc = nodes.get(j)[1];
                int d = dist[tr][tc];
                if (d>=0) edges.add(new Edge(i,j,d));
            }
        }
        Collections.sort(edges);
        UnionFind uf = new UnionFind(V);
        int used = 0;
        int total = 0;
        for (Edge e : edges) {
            if (uf.union(e.u, e.v)) {
                total += e.w;
                used++;
                if (used == V-1) break;
            }
        }
        if (used != V-1) System.out.println(-1);
        else System.out.println(total);
    }

    static int[][] bfs(int sr, int sc) {
        int[][] dist = new int[N][N];
        for (int i=0;i<N;i++) Arrays.fill(dist[i], -1);
        Queue<int[]> q = new ArrayDeque<>();
        dist[sr][sc]=0;
        q.add(new int[]{sr,sc});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int k=0;k<4;k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr<0||nr>=N||nc<0||nc>=N) continue;
                if (map[nr][nc]=='1') continue;
                if (dist[nr][nc]!=-1) continue;
                dist[nr][nc]=dist[r][c]+1;
                q.add(new int[]{nr,nc});
            }
        }
        return dist;
    }
}