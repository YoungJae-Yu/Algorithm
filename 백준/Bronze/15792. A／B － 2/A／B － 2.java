import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();
        
        sb.append(A / B).append('.');
        int remainder = A % B;
        
        for (int i = 0; i < 1000; i++) {
            remainder *= 10;
            sb.append(remainder / B);
            remainder %= B;
        }
        
        System.out.println(sb);
        br.close();
    }
}