import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int Rg = Integer.parseInt(st.nextToken());
        int Cg = Integer.parseInt(st.nextToken());
        int Rp = Integer.parseInt(st.nextToken());
        int Cp = Integer.parseInt(st.nextToken());
        
        int pillowArea = Rp * Cp;
        int countP = 0;
        
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                if (line.charAt(j) == 'P') {
                    countP++;
                }
            }
        }
        
        System.out.println(countP < pillowArea ? 1 : 0);
    }
}