import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        s = s.replace('|', '.');
        s = s.replace(':', '.');
        s = s.replace('#', '.');
        String[] parts = s.split("\\.");
        long sum = 0;
        for (String p : parts) {
            if (!p.isEmpty()) sum += Integer.parseInt(p);
        }
        System.out.println(sum);
    }
}