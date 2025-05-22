import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String S = st.nextToken();

        List<String> chats = new ArrayList<>();
        String answer = "";
        boolean found = false;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String nick = st.nextToken();
            String chat = st.nextToken();
            if (!found) {
                if (nick.equals(S)) {
                    answer = chat;
                    found = true;
                } else {
                    chats.add(chat);
                }
            }
        }

        int count = 0;
        for (String c : chats) {
            if (c.equals(answer)) count++;
        }

        System.out.println(count);
    }
}