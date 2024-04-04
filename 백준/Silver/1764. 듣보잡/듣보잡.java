import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> notHeard = new HashSet<>();
        ArrayList<String> notHeardSeen = new ArrayList<>();

        // 듣도 못한 사람의 명단을 HashSet에 저장
        for (int i = 0; i < N; i++) {
            notHeard.add(br.readLine());
        }

        // 보도 못한 사람의 명단을 확인하며 듣도 못한 명단에 있으면 ArrayList에 추가
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (notHeard.contains(name)) {
                notHeardSeen.add(name);
            }
        }

        // 사전순으로 정렬
        Collections.sort(notHeardSeen);

        // 출력
        System.out.println(notHeardSeen.size());
        for (String name : notHeardSeen) {
            System.out.println(name);
        }
    }
}
