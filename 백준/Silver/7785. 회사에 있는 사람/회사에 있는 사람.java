import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 로그 기록의 수
        HashMap<String, String> logs = new HashMap<>(); // 출입 로그를 저장할 해시맵

        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");
            logs.put(log[0], log[1]); // 이름을 키로, 출입 상태를 값으로 저장
        }

        ArrayList<String> present = new ArrayList<>(); // 회사에 남아 있는 사람들을 저장할 리스트
        for (String name : logs.keySet()) {
            if (logs.get(name).equals("enter")) {
                present.add(name); // 'enter' 상태인 사람들을 리스트에 추가
            }
        }

        Collections.sort(present, Collections.reverseOrder()); // 사전 순의 역순으로 정렬

        // 결과를 출력
        for (String name : present) {
            System.out.println(name);
        }
    }
}
