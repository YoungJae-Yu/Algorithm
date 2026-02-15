import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        if(n==1){
            System.out.println(1);
            return;
        }
        int MAX = 2000005;
        int[] a = new int[MAX];
        a[1] = 1;
        int idx = 2;
        long sum = 1;
        while(sum < n){
            a[idx] = 1 + a[idx - a[a[idx-1]]];
            sum += a[idx];
            idx++;
            if(idx >= MAX) break;
        }
        System.out.println(idx-1);
    }
}