import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            map.put(parts[1].charAt(0), parts[0]);
        }
        String compressed = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (char c : compressed.toCharArray()) {
            sb.append(map.get(c));
        }
        String[] se = br.readLine().split(" ");
        int S = Integer.parseInt(se[0]);
        int E = Integer.parseInt(se[1]);
        String result = sb.toString().substring(S - 1, E);
        System.out.print(result);
    }
}