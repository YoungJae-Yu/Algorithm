import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사람들이 만난 기록의 수 N
        HashMap<String, Boolean> map = new HashMap<>(); // 각 사람이 무지개 댄스를 추고 있는지 여부 저장
        map.put("ChongChong", true); // 총총이는 처음부터 무지개 댄스를 춤

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String A = st.nextToken(); // 만난 사람 A
            String B = st.nextToken(); // 만난 사람 B

            // A 또는 B 중 한 명이라도 무지개 댄스를 추고 있다면, 둘 다 무지개 댄스를 추게 됨
            if (map.getOrDefault(A, false) || map.getOrDefault(B, false)) {
                map.put(A, true);
                map.put(B, true);
            }
        }

        // 최종적으로 무지개 댄스를 추는 사람의 수를 세어 출력
        long count = map.values().stream().filter(b -> b).count();
        System.out.println(count);
    }
}
