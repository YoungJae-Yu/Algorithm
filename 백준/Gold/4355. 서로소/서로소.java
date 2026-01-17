import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null){
            long n = Long.parseLong(line.trim());
            if(n == 0) break;
            if(n == 1){
                sb.append("0\n");
                continue;
            }
            long orig = n;
            long phi = orig;
            for(long p = 2; p * p <= n; p++){
                if(n % p == 0){
                    phi -= phi / p;
                    while(n % p == 0) n /= p;
                }
            }
            if(n > 1) phi -= phi / n;
            sb.append(phi).append('\n');
        }
        System.out.print(sb.toString());
    }
}