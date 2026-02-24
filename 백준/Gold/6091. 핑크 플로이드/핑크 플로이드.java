import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{
    static class Edge implements Comparable<Edge>{
        int u,v,w;
        Edge(int u,int v,int w){this.u=u;this.v=v;this.w=w;}
        public int compareTo(Edge o){return this.w - o.w;}
    }
    static class UF{
        int[] p;
        UF(int n){p=new int[n+1];for(int i=1;i<=n;i++)p[i]=i;}
        int find(int x){return p[x]==x?x:(p[x]=find(p[x]));}
        boolean union(int a,int b){
            a=find(a);b=find(b);
            if(a==b) return false;
            p[b]=a; return true;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine().trim());
        List<Edge> edges=new ArrayList<>();
        for(int i=1;i<=N-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine().trim());
            for(int j=i+1;j<=N;j++){
                if(st.hasMoreTokens()){
                    int w=Integer.parseInt(st.nextToken());
                    edges.add(new Edge(i,j,w));
                }
            }
        }
        Collections.sort(edges);
        UF uf=new UF(N);
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=N;i++) adj.add(new ArrayList<>());
        int count=0;
        for(Edge e:edges){
            if(uf.union(e.u,e.v)){
                adj.get(e.u).add(e.v);
                adj.get(e.v).add(e.u);
                count++;
                if(count==N-1) break;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=N;i++){
            List<Integer> list=adj.get(i);
            Collections.sort(list);
            sb.append(list.size());
            for(int v:list) sb.append(' ').append(v);
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}