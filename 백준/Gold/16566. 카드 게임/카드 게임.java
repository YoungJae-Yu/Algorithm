import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    static void union(int x){
        parent[x] = x+1;
    }
    public static void main(String[] args) throws Exception{
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();
        int M = fs.nextInt();
        int K = fs.nextInt();
        int[] arr = new int[M];
        for(int i=0;i<M;i++) arr[i] = fs.nextInt();
        Arrays.sort(arr);
        parent = new int[M+1];
        for(int i=0;i<=M;i++) parent[i]=i;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<K;i++){
            int x = fs.nextInt();
            int idx = upperBound(arr, x);
            if(idx==M) idx = 0;
            idx = find(idx);
            if(idx==M) idx = find(0);
            sb.append(arr[idx]).append('\n');
            union(idx);
        }
        System.out.print(sb.toString());
    }
    static int upperBound(int[] a, int key){
        int l=0, r=a.length;
        while(l<r){
            int mid = (l+r)>>>1;
            if(a[mid] <= key) l = mid+1;
            else r = mid;
        }
        return l;
    }
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1<<16];
        private int ptr = 0, len = 0;
        private int read() throws IOException{
            if(ptr >= len){
                len = in.read(buffer);
                ptr = 0;
                if(len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException{
            int c;
            while((c = read()) <= ' ') if(c == -1) return -1;
            int sign = 1;
            if(c == '-'){ sign = -1; c = read(); }
            int val = 0;
            while(c > ' '){
                val = val*10 + c - '0';
                c = read();
            }
            return val*sign;
        }
    }
}