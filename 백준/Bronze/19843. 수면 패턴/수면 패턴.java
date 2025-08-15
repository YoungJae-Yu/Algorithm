import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Map<String,Integer> idx = new HashMap<>();
        idx.put("Mon",0); idx.put("Tue",1); idx.put("Wed",2); idx.put("Thu",3); idx.put("Fri",4);
        int slept = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String d1 = st.nextToken();
            int h1 = Integer.parseInt(st.nextToken());
            String d2 = st.nextToken();
            int h2 = Integer.parseInt(st.nextToken());
            int dur = (idx.get(d2) - idx.get(d1)) * 24 + (h2 - h1);
            slept += dur;
        }
        int need = T - slept;
        if (need > 48) System.out.println(-1);
        else if (need > 0) System.out.println(need);
        else System.out.println(0);
    }
}