import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        long w;
        Edge(int to, long w){ this.to = to; this.w = w; }
    }
    static class Node implements Comparable<Node> {
        int v;
        long dist;
        Node(int v, long dist){ this.v = v; this.dist = dist; }
        public int compareTo(Node o){ return Long.compare(this.dist, o.dist); }
    }
    static class WNode implements Comparable<WNode> {
        int v;
        int state;
        long dist;
        WNode(int v, int state, long dist){ this.v = v; this.state = state; this.dist = dist; }
        public int compareTo(WNode o){ return Long.compare(this.dist, o.dist); }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] g = new ArrayList[N+1];
        for (int i=1;i<=N;i++) g[i] = new ArrayList<>();
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            long w = (long)d * 2;
            g[a].add(new Edge(b, w));
            g[b].add(new Edge(a, w));
        }

        final long INF = Long.MAX_VALUE / 4;

        long[] distFox = new long[N+1];
        Arrays.fill(distFox, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distFox[1] = 0;
        pq.add(new Node(1, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if (cur.dist != distFox[cur.v]) continue;
            for (Edge e : g[cur.v]){
                if (distFox[e.to] > distFox[cur.v] + e.w){
                    distFox[e.to] = distFox[cur.v] + e.w;
                    pq.add(new Node(e.to, distFox[e.to]));
                }
            }
        }

        long[][] distWolf = new long[N+1][2];
        for (int i=1;i<=N;i++){
            distWolf[i][0] = INF;
            distWolf[i][1] = INF;
        }
        PriorityQueue<WNode> wpq = new PriorityQueue<>();
        distWolf[1][1] = 0;
        wpq.add(new WNode(1, 1, 0));
        while(!wpq.isEmpty()){
            WNode cur = wpq.poll();
            if (cur.dist != distWolf[cur.v][cur.state]) continue;
            for (Edge e : g[cur.v]){
                if (cur.state == 1){
                    long nd = cur.dist + e.w/2;
                    if (distWolf[e.to][0] > nd){
                        distWolf[e.to][0] = nd;
                        wpq.add(new WNode(e.to, 0, nd));
                    }
                } else {
                    long nd = cur.dist + e.w*2;
                    if (distWolf[e.to][1] > nd){
                        distWolf[e.to][1] = nd;
                        wpq.add(new WNode(e.to, 1, nd));
                    }
                }
            }
        }

        int ans = 0;
        for (int i=1;i<=N;i++){
            long wolfMin = Math.min(distWolf[i][0], distWolf[i][1]);
            if (distFox[i] < wolfMin) ans++;
        }
        System.out.println(ans);
    }
}