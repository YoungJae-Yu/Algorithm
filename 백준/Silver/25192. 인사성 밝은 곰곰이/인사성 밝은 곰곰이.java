import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 곰곰티콘 사용 횟수를 계산하는 프로그램입니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        HashSet<String> greetedUsers = new HashSet<>();
        int greetingCount = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (input.equals("ENTER")) {
                // 새로운 사람이 입장했으므로, 인사한 사용자 목록을 초기화합니다.
                greetedUsers.clear();
            } else {
                // 사용자가 처음 채팅을 입력하는 경우 곰곰티콘으로 인사합니다.
                if (!greetedUsers.contains(input)) {
                    greetedUsers.add(input);
                    greetingCount++;
                }
            }
        }

        System.out.println(greetingCount);
    }
}
