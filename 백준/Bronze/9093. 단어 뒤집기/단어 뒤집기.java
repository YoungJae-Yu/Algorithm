import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            String[] arr = br.readLine().split(" ");
            for(int i = 0; i < arr.length; i++){
                sb.append(new StringBuilder(arr[i]).reverse());
                if(i < arr.length - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}